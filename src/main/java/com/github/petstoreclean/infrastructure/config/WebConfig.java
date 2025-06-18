package com.github.petstoreclean.infrastructure.config;

import jakarta.servlet.ServletContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@Configuration
public class WebConfig {

    /*
        Facade for Thymeleaf web application. We need this
        to be able to construct web exchange objects when
        rendering templates in our Presenters.
     */

    @Bean
    @ConditionalOnMissingBean
    public JakartaServletWebApplication thymeleafApplication(ServletContext servletContext) {
        return JakartaServletWebApplication.buildApplication(servletContext);
    }

}
