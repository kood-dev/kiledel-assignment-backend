package com.kiledel.common.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponse<T> {
    private final String code;
    private final String message;
    private final T data;

    private CommonResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static CommonResponse ok() {
        return ok(null);
    }

    public static <T> CommonResponse<T> ok(final T data) {
        return new CommonResponse(Integer.toString(HttpStatus.OK.value()), HttpStatus.OK.getReasonPhrase(), data);
    }
    public static <T> CommonResponse<T> accepted(final T data) {
        return new CommonResponse(Integer.toString(HttpStatus.ACCEPTED.value()), HttpStatus.ACCEPTED.getReasonPhrase(), data);
    }

    public static <T> CommonResponse<T> accepted() {
        return accepted(null);
    }
}
