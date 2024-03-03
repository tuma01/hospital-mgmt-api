package com.amachi.app.hospitalappservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;



@Component
public class Translator {
    public static ResourceBundleMessageSource messageSource;

    @PostConstruct
    public void init() {
        messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("errors");
    }

    public static String toLocale(String code, Object[] args) {
        return messageSource.getMessage(code, args, null);
    }
}
