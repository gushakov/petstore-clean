package com.github.petstoreclean.core.usecase.welcome;

import com.github.petstoreclean.infrastructure.adapter.web.ErrorHandlingPresenterOutputPort;

public interface WelcomePresenterOutputPort extends ErrorHandlingPresenterOutputPort {

    void presentWelcomePage();

}
