package com.amachi.app.hospitalappservice.config.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "hospital")
@Validated
@Getter@Setter
@ToString
public class HospitalProperties {

    @Value("hospital-app-service")
    private String springApplicationName;
    @Value("1.0.0")
    private String springApplicationVersion;
}
