package com.amachi.app.hospitalappservice.exception;

import com.amachi.app.hospitalappservice.common.exception.HospitalException;
import com.amachi.app.hospitalappservice.common.exception.ResourceNotFoundException;
import com.amachi.app.hospitalappservice.service.ErrorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    private final ErrorService errorService;
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
//        List<String> errors = ex.getBindingResult().getFieldErrors()
//                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
//    }
//
//    private Map<String, List<String>> getErrorsMap(List<String> errors) {
//        Map<String, List<String>> errorResponse = new HashMap<>();
//        errorResponse.put("errors", errors);
//        return errorResponse;
//    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorMessage> handleSQLException(SQLException ex, WebRequest request) {
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HospitalInternalException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(HospitalInternalException ex, WebRequest request) {
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ErrorMessage> resourceNotFoundException(ConstraintViolationException ex, WebRequest request) {
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HospitalException.class)
    public ResponseEntity<ErrorMessage> resourceObjectNotFounded(HospitalException ex, WebRequest request) {
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorMessage> resourceObjectNotFounded(NoSuchElementException ex, WebRequest request) {
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }


//    @ExceptionHandler(RuntimeException.class)
//    public final ResponseEntity<ErrorMessage> handleRuntimeExceptions(RuntimeException ex, WebRequest request) {
//        List<String> errors = Collections.singletonList(ex.getMessage());
//        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
//    }
}
