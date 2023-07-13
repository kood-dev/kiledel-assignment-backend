package com.kiledel.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final ExceptionType exceptionType;
    private final String message;

    public BusinessException(ExceptionType exceptionType, String message) {
        this.exceptionType = exceptionType;
        this.message = message;
    }

    public BusinessException(ExceptionType exceptionType) {
        this(exceptionType, exceptionType.getMessage());
    }

    public static BusinessException of(ExceptionType exceptionType, String message) {
        return new BusinessException(exceptionType, message);
    }

}

