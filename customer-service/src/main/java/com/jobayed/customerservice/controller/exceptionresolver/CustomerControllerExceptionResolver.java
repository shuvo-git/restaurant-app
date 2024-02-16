package com.jobayed.customerservice.controller.exceptionresolver;

import com.jobayed.customerservice.controller.endpoint.CustomerController;
import com.jobayed.customerservice.exception.BaseException;
import com.jobayed.customerservice.exception.Error;
import com.jobayed.customerservice.utility.Constants;
import com.jobayed.customerservice.utility.ErrorCode;
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
@ControllerAdvice(assignableTypes = {CustomerController.class})
@Slf4j
public class CustomerControllerExceptionResolver {
    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        if (ex instanceof BaseException bex) {

            Error error = bex.getError();
            String errCode = Constants.FeatureCode.CUSTOMER + error.getErrorCode();
            error.setErrorCode(errCode);
            return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.OK, request);
        }
        Error error = Error.builder()
                .errorCode(Constants.FeatureCode.CUSTOMER + ErrorCode.INTERNAL_SERVER_ERROR.getCode())
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
}
