package com.kiledel.common.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiledel.common.model.CommonErrorResponse;
import com.kiledel.common.model.ValidationExceptionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {
    private final ObjectMapper objectMapper;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CommonErrorResponse> handleException(BusinessException businessException) {
        log.error("[Exception] Unchecked business exception occurred");
        return ResponseEntity
                .status(businessException.getExceptionType().getStatus())
                .body(CommonErrorResponse.of(businessException));
    }

    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    private ResponseEntity<Object> handleBindException(final BindException bindException) throws JsonProcessingException {
        List<FieldError> fieldErrorList = bindException.getBindingResult().getFieldErrors();
        Map<String, String> errorFieldMap = fieldErrorList.stream().collect(
                Collectors.toMap(FieldError::getField,
                        DefaultMessageSourceResolvable::getDefaultMessage
                ));

        log.error("Validation exception occurred - {}", objectMapper.writeValueAsString(errorFieldMap));

        return ResponseEntity.badRequest().body(
                ValidationExceptionResponse.of(
                        ExceptionType.INVALID_REQUEST.getCode(),
                        ExceptionType.INVALID_REQUEST.getMessage(),
                        errorFieldMap)
        );
    }


    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleUnexpectedException(final Exception e) {
        log.error("Unexpected error", e);

        return ResponseEntity
                .internalServerError()
                .body(CommonErrorResponse.of(ExceptionType.UNEXPECTED.getCode(), e.getMessage()));
    }

}
