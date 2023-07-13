package com.kiledel.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {
    BAD_REQUEST("400401", HttpStatus.BAD_REQUEST.value(), "exception.standard.badRequest"),
    INVALID_REQUEST("400402", HttpStatus.BAD_REQUEST.value(), "exception.common.validation.request"),
    NOT_FOUND("404401", HttpStatus.NOT_FOUND.value(), "exception.standard.notFound"),
    NOT_FOUND_RESULT("404402", HttpStatus.NOT_FOUND.value(), "exception.business.notFound.result"),
    UNEXPECTED("500501", HttpStatus.INTERNAL_SERVER_ERROR.value(), "exception.standard.unexpected");

    private final String code;
    private final int status;
    private final String message;
}
