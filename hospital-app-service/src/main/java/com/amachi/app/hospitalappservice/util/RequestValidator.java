package com.amachi.app.hospitalappservice.util;

import com.amachi.app.hospitalappservice.common.exception.NoParametersProvidedException;
import com.amachi.app.hospitalappservice.dto.request.GetCountriesRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {
    private static final GetCountriesRequest EMPTY_GET_COUNTRY_REQUEST = new GetCountriesRequest();

    public boolean validateGetCountriesRequest(GetCountriesRequest getCountriesRequest) throws NoParametersProvidedException {
        if(getCountriesRequest.equals(EMPTY_GET_COUNTRY_REQUEST)) {
            throw new NoParametersProvidedException();
        }
        return true;
    }
}
