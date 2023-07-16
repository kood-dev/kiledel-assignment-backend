package com.kiledel.common.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RedisConfiguration {
    @Value("${spring.data.redis.port}")
    private int port;

    @Value("${spring.data.redis.url}")
    private String url;

    @Bean
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress(getAddress());
        return Redisson.create(config);
    }

    private String getAddress() {
        return String.format("redis://%s:%s", url, port);
    }
}
