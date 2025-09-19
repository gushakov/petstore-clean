package com.github.petstoreclean.infrastructure.adapter.web;

import java.util.Map;

public interface ErrorHandlingPresenterOutputPort {

    void presentSuccess(String template);

    void presentSuccess(String template, Map<String, Object> variables);

    void presentSuccessWithMessage(String template, String successMessage);

    void presentSuccessWithMessage(String template, String successMessage, Map<String, Object> variables);

    void presentSuccessMessage(String successMessage);

    void presentError(Exception e);

    void presentErrorMessage(String errorMessage);
}
