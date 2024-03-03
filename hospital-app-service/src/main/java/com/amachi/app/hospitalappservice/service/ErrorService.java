package com.amachi.app.hospitalappservice.service;

import com.amachi.app.hospitalappservice.config.properties.HospitalProperties;
import com.amachi.app.hospitalappservice.exception.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class ErrorService {

    private HospitalProperties hospitalProperties;

//    public ErrorHospital generateError(String code, String text) {
//        ErrorHospital error = new ErrorHospital();
//        error.setCode(code);
//        error.setOrigin(hospitalProperties.getSpringApplicationName());
//        error.setText(text);
//        return error;
//    }

    public ErrorMessage generateErrorMessage(int statusCode, String message, String description) {
        return ErrorMessage.builder()
                .statusCode(statusCode)
                .timestamp(new Date())
                .message(message)
                .description(description)
//                .origin(hospitalProperties.getSpringApplicationName())
                .origin("Hospital-app-service")
                .build();
    }
}
