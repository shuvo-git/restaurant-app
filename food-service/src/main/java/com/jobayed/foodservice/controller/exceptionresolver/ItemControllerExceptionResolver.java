package com.jobayed.foodservice.controller.exceptionresolver;

import com.jobayed.foodservice.config.AppProperties;
import com.jobayed.foodservice.controller.endpoint.ItemController;
import com.jobayed.foodservice.exception.BaseException;
import com.jobayed.foodservice.exception.Error;
import com.jobayed.foodservice.utility.Constants;
import com.jobayed.foodservice.utility.ErrorCode;
import lombok.RequiredArgsConstructor;
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
@ControllerAdvice(assignableTypes = {ItemController.class})
@Slf4j
@RequiredArgsConstructor
public class ItemControllerExceptionResolver {
    private final AppProperties properties;

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        if (ex instanceof BaseException bex) {
            Error error = bex.getError();
            error.setErrorCode(this.buildErrorCode(error.getErrorCode()));
            return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.OK, request);
        }

        String errCode = this.buildErrorCode(ErrorCode.INTERNAL_SERVER_ERROR.getCode());
        Error error = Error.builder()
                .errorCode(errCode)
                .errorMessage(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
        return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(body, headers, status);
    }

    private String buildErrorCode(final String errorCode) {
        return new StringBuilder().append(properties.getCode())
                .append('_')
                .append(Constants.FeatureCode.ITEM)
                .append('_')
                .append(errorCode)
                .toString();
    }
}
