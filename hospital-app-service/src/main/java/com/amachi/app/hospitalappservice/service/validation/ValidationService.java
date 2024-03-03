package com.amachi.app.hospitalappservice.service.validation;

import jakarta.validation.Validator;

import java.util.Map;

public interface ValidationService<T> {

    public void validateReceivedEntity(Map<String, String> headers, T entity);
}
