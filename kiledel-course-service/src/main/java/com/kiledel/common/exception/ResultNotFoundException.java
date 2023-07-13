package com.kiledel.common.exception;

public class ResultNotFoundException extends BusinessException {
    private static final ExceptionType EXCEPTION_TYPE = ExceptionType.NOT_FOUND_RESULT;

    public ResultNotFoundException() {
        super(EXCEPTION_TYPE);
    }
    public ResultNotFoundException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
