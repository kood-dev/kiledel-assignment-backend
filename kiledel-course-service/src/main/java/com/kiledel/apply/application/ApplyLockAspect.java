package com.kiledel.apply.application;

import com.kiledel.common.exception.BusinessException;
import com.kiledel.common.exception.ExceptionType;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Slf4j
@RequiredArgsConstructor
@Component
public class ApplyLockAspect {
    private final static String APPLY_LOCK_KEY = "course:lock:apply:%s:%s";
    private final RedissonClient redissonClient;

    @Around("@annotation(com.kiledel.apply.application.ApplyLock)")
    public Object lock(final ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ApplyLock applyLock = method.getAnnotation(ApplyLock.class);

        String key = createKey(joinPoint.getArgs());
        if (StringUtils.isEmpty(key)) {
            log.info("RedissonLock Apply Lockable false method : {}", method.getName());
            return joinPoint.proceed();
        }

        RLock lock = redissonClient.getLock(key);
        try {
            boolean locked = lock.tryLock(applyLock.waitTime(), applyLock.leaseTime(), applyLock.timeUnit());
            if (!locked) {
                log.info("RedissonLock Apply Locked fail {}", key);
            }
            log.info("RedissonLock Apply Locked!! : {}", key);
            return joinPoint.proceed();
        } catch (InterruptedException ie) {
            log.error("RedissonLock Apply TryLock InterruptedException", ie);
            throw BusinessException.of(ExceptionType.DISABLED_REDISSON_LOCK);
        } finally {
            unlock(lock);
            log.info("RedissonLock Apply unlocked!! : {}", key);
        }
    }

    private void unlock(RLock lock) {
        if (lock != null && lock.isLocked()) {
            lock.unlock();
        } else {
            log.error("RedissonLock Apply UnLock Disabled");
        }
    }

    private String createKey(Object[] args) {
        String resultKey = null;
        for (Object arg : args) {
            if (arg instanceof ApplyLockable) {
                Long courseId = ((ApplyLockable) arg).getCourseId();
                String employeeNo = ((ApplyLockable) arg).getEmployeeNo();

                resultKey = generateLockKey(courseId, employeeNo);
                break;
            }
        }
        return resultKey;
    }

    public boolean getLock(String key, long lockSec) {
        return redissonClient.getBucket(key).trySet(Boolean.TRUE, lockSec, TimeUnit.SECONDS);
    }

    public boolean getLock(String methodName, String id, long lockSec) {
        StringBuilder key = new StringBuilder(APPLY_LOCK_KEY);
        key.append(methodName);
        key.append(id);

        return redissonClient.getBucket(key.toString()).trySet(Boolean.TRUE, lockSec, TimeUnit.SECONDS);
    }

    public String generateLockKey(Long courseId, String employeeNo) {
        return String.format(APPLY_LOCK_KEY, courseId, employeeNo);
    }
}
