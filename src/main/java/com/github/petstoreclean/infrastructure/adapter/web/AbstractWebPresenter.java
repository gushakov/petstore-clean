package com.github.petstoreclean.infrastructure.adapter.web;

import com.github.petstoreclean.infrastructure.adapter.web.map.UiMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class AbstractWebPresenter implements ErrorHandlingPresenterOutputPort {

    @Autowired
    private JakartaServletWebApplication thymeleafApplication;
    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    protected UiMapper uiMapper;

    @Override
    public void presentSuccess(String template) {
        doProcessTemplates(null, template);
    }

    @Override
    public void presentSuccess(String template, Map<String, Object> variables) {
        doProcessTemplates(variables, template);
    }

    @Override
    public void presentSuccessWithMessage(String template, String successMessage) {
        doProcessTemplates(successVars(successMessage), "success", template);
    }

    @Override
    public void presentSuccessWithMessage(String template, String successMessage, Map<String, Object> variables) {
        Map<String, Object> allVariables = new HashMap<>(variables);
        allVariables.putAll(successVars(successMessage));
        doProcessTemplates(allVariables, "success", template);
    }

    @Override
    public void presentSuccessMessage(String successMessage) {
        doProcessTemplates(successVars(successMessage),
                "success");
    }

    @Override
    public void presentError(Exception e) {
        log.error(e.getMessage(), e);
        doProcessTemplates(null, "error");
    }

    @Override
    public void presentErrorMessage(String errorMessage) {
        doProcessTemplates(errorVars(errorMessage), "error");
    }

    /**
     * Transforms provided templated HTML fragments and writes them to the HTTP response
     * using provided variables.
     *
     * @param variables variables to be used in the templates, may be null
     * @param templates Thymeleaf templates to be processed
     */
    protected void doProcessTemplates(Map<String, Object> variables, String... templates) {

        if (templates.length == 0) {
            throw new IllegalArgumentException("At least one template must be provided");
        }

        WebContext webContext = new WebContext(thymeleafApplication.buildExchange(request, response),
                Locale.ENGLISH, variables);

        try (PrintWriter writer = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setStatus(HttpStatus.OK.value());
            for (String template : templates) {
                templateEngine.process(template, webContext, writer);
            }
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private Map<String, Object> successVars(String successMessage) {
        return Map.of("successMessage",
                Optional.ofNullable(successMessage).orElse("Message is null"));
    }

    private Map<String, Object> errorVars(String errorMessage) {
        return Map.of("errorMessage", Optional.ofNullable(errorMessage).orElse("Error message is null"));
    }
}
