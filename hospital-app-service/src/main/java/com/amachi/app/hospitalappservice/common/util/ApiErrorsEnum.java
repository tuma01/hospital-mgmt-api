package com.amachi.app.hospitalappservice.common.util;

import com.amachi.app.hospitalappservice.config.Translator;
import com.amachi.app.hospitalappservice.util.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiErrorsEnum {

    HEADER_MISSING("HEADER_MISSING", Translator.toLocale(AppConstants.HEADER_MISSING, null), HttpStatus.BAD_REQUEST, "R_HAS_001"),
    HEADER_FORMAT_ERROR("HEADER_FORMAT_ERROR", Translator.toLocale(AppConstants.HEADER_FORMAT_ERROR, null), HttpStatus.BAD_REQUEST, "R_HAS_002"),
    ACCEPT_VERSION_NOT_SUPPORTED("ACCEPT_VERSION_NOT_SUPPORTED", Translator.toLocale(AppConstants.ACCEPT_VERSION_NOT_SUPPORTED, null), HttpStatus.NOT_ACCEPTABLE, "R_HAS_003"),
    ACCEPT_NOT_SUPPORTED("ACCEPT_NOT_SUPPORTED", Translator.toLocale(AppConstants.ACCEPT_NOT_SUPPORTED, null), HttpStatus.NOT_ACCEPTABLE, "R_HAS_004"),
    PARAM_FORMAT_ERROR("PARAM_FORMAT_ERROR", Translator.toLocale(AppConstants.PARAM_FORMAT_ERROR, null), HttpStatus.BAD_REQUEST, "R_HAS_005"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", Translator.toLocale(AppConstants.INTERNAL_SERVER_ERROR, null), HttpStatus.INTERNAL_SERVER_ERROR, "R_HAS_006");

    public final String code;
    public final String message;
    public final HttpStatus status;
    public final String rule;

    ApiErrorsEnum(String code, String message, HttpStatus status, String rule) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.rule = rule;
    }
}
