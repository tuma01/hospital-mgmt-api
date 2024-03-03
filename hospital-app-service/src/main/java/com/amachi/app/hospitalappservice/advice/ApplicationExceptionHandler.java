package com.amachi.app.hospitalappservice.advice;

import com.amachi.app.hospitalappservice.common.exception.ErrorResponse;
import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.exception.NoParametersProvidedException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
//        for (ConstraintViolation violation : e.getConstraintViolations()) {
//            error.getViolations().add(
//                    new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
//        }
        e.getConstraintViolations().forEach(err -> error.getViolations().add(
                new Violation(err.getPropertyPath().toString(), err.getMessage())
        ));
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        e.getBindingResult().getFieldErrors().forEach(err -> error.getViolations().add(
                new Violation(err.getField(), err.getDefaultMessage()
        )));
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HospitalException.class)
    @ResponseBody
    ValidationErrorResponse handleBusinessException(HospitalException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation("errorMensaje", e.getMessage()));
        return error;
    }

    @ExceptionHandler(NoParametersProvidedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handleNoParametersProvidedException(NoParametersProvidedException ex) {
        log.error("No Parameters Provided exception occurred: {}", ex.getMessage());
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation("errorMensaje", ex.getMessage()));
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ValidationErrorResponse notValid(RuntimeException ex, HttpServletRequest request) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getViolations().add(new Violation("errorMensaje", ex.getMessage()));
        return error;
    }
}
