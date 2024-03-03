package com.amachi.app.hospitalappservice.exception;

import com.amachi.app.hospitalappservice.service.ErrorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
//import rest.exceptions.UserNotFoundException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {
    private final ErrorService errorService;
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request) {
//        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<Map<String, List<String>>> handleNotFoundException(UserNotFoundException ex) {
//        List<String> errors = Collections.singletonList(ex.getMessage());
//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorMessage> handleGeneralExceptions(Exception ex, WebRequest request) {
//        List<String> errors = Collections.singletonList(ex.getMessage());
//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorMessage> handleRuntimeExceptions(RuntimeException ex, WebRequest request) {
//        List<String> errors = Collections.singletonList(ex.getMessage());
//        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        ErrorMessage errorMessage = errorService.generateErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

}