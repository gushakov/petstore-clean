package com.github.petstoreclean.infrastructure.adapter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class AbstractWebController {

    @Autowired
    private ApplicationContext applicationContext;

    protected <T> T useCase(Class<T> inputPortType) {
        return applicationContext.getBean(inputPortType);
    }
}
