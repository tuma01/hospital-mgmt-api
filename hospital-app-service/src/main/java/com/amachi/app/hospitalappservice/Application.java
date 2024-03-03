package com.amachi.app.hospitalappservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@ComponentScan("com.amachi.app.hospitalappservice")
//@ConfigurationPropertiesScan
@Slf4j
@OpenAPIDefinition(info = @Info(title = "Hospital Microservice REST API Documentation", version = "v1",
        description = "Hospital Microservice REST API Documentation",
contact = @Contact(
        name = "Juan Amachi",
        email = "juan.amachi@gmail.com",
        url = "www.amachi.com"
)))
@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Hospital API Microservice Started!");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
