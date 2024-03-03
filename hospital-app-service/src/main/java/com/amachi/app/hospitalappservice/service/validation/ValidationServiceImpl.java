package com.amachi.app.hospitalappservice.service.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class ValidationServiceImpl<M> {
    protected final Validator validator;

    public void validateReceivedEntity(Map<String, String> headers, M entity) {
        validateHeaders(headers);
        validateEntity(entity);
    }

    private void validateEntity(M entity) {
//        Set<ConstraintViolation<entity>> violations = validator.validate(entity)
    }

    private void validateHeaders(Map<String, String> headers) {
    }
}
