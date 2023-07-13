package com.kiledel.common.model;

import lombok.Getter;
import lombok.NonNull;

import java.util.Map;

@Getter
public class ValidationExceptionResponse extends CommonErrorResponse {
    private final Map<String, String> errorFieldMap;

    private ValidationExceptionResponse(String code, String message, Map<String, String> errorFieldMap) {
        super(code, message);
        this.errorFieldMap = errorFieldMap;
    }

    public static ValidationExceptionResponse of(final String code, final String message, final Map<String, String> errorFieldMap) {
        return new ValidationExceptionResponse(code, message, errorFieldMap);
    }
}