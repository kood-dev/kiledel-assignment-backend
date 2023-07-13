package com.kiledel.common.model;

import com.kiledel.common.exception.BusinessException;
import lombok.Getter;

@Getter
public class CommonErrorResponse {
    private final String code;
    private final String message;

    CommonErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public static CommonErrorResponse of(BusinessException businessException) {
        return new CommonErrorResponse(
                businessException.getExceptionType().getCode(),
                businessException.getMessage()
        );
    }

    public static CommonErrorResponse of(String code, String message) {
        return new CommonErrorResponse(code, message);
    }
}
