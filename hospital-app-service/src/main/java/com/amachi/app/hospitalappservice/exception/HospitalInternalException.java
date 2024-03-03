package com.amachi.app.hospitalappservice.exception;

import com.amachi.app.hospitalappservice.common.util.ApiErrorsEnum;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

@Getter@Setter
public class HospitalInternalException extends RuntimeException{
    private final String code;
    private final String value;
    private final HttpStatus status;

    public HospitalInternalException(ApiErrorsEnum apiErrorsEnum, String value) {
        super(String.format("%s: %s", value, apiErrorsEnum.getMessage()));
        this.value = value;
        this.status = apiErrorsEnum.getStatus();
        this.code = apiErrorsEnum.getCode();
    }

    public HospitalInternalException (ApiErrorsEnum apiErrorsEnum) {
        super(String.format("%s", apiErrorsEnum.getMessage()));
        this.value = StringUtils.EMPTY;
        this.status = apiErrorsEnum.getStatus();
        this.code = apiErrorsEnum.getCode();
    }
}
