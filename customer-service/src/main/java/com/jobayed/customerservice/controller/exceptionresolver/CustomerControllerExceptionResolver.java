package com.jobayed.customerservice.controller.exceptionresolver;

import com.jobayed.customerservice.exception.BaseException;
import com.jobayed.customerservice.exception.Error;
import com.jobayed.customerservice.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

/**
 * Vantage Labs LLC.
 * User: Jobayed Ullah
 * Time: 2/13/24 6:09 PM
 */
@ControllerAdvice
@Slf4j
public class CustomerControllerExceptionResolver {
    String featureCode = "001_";

    @ExceptionHandler(value = {NullPointerException.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ApiResponse(responseCode = "400", description = "If any preconditions fails.",
//            content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    protected ResponseEntity<Object> handleConstraintViolation(RuntimeException ex, WebRequest request) {
        if (ex instanceof BaseException bex) {
            Error error = Error.builder()
                    .errorCode(featureCode + bex.getCode())
                    .errorMessage(bex.getMessage())
                    .build();
            return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.OK, request);
        }

        Error error = Error.builder()
                .errorCode(featureCode + ErrorCode.INTERNAL_SERVER_ERROR.code)
                .errorMessage(ErrorCode.INTERNAL_SERVER_ERROR.message)
                .build();
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        Thread.currentThread().

        log.error(ex.getMessage(),ex);
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
