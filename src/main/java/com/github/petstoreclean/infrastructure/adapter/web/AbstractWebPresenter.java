package com.github.petstoreclean.infrastructure.adapter.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.PrintWriter;
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

    public void presentSuccess(String template) {
        presentSuccess(template, Map.of());
    }

    public void presentSuccess(String template, Map<String, Object> variables) {

        try (PrintWriter writer = response.getWriter()) {
            setUpOkResponse();
            WebContext webContext = new WebContext(thymeleafApplication.buildExchange(request, response),
                    Locale.ENGLISH, variables);
            templateEngine.process(template, webContext, writer);
            writer.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void presentError(Exception e) {
        log.error(e.getMessage(), e);
        presentError(e.getMessage());
    }


    @Override
    public void presentError(String errorMessage) {
        try (PrintWriter writer = response.getWriter()) {
            setUpErrorResponse(HttpStatus.BAD_REQUEST);
            WebContext webContext = new WebContext(thymeleafApplication.buildExchange(request, response),
                    Locale.ENGLISH, Map.of("errorMessage", Optional.ofNullable(errorMessage).orElse("Message is null")));
            templateEngine.process("error", webContext, writer);
            writer.flush();
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }

    private void setUpResponseCommon() {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    private void setUpOkResponse() {
        setUpResponseCommon();
        response.setStatus(HttpStatus.OK.value());
    }

    private void setUpErrorResponse(HttpStatus errorStatus) {
        setUpResponseCommon();
        response.setStatus(errorStatus.value());
    }

}
