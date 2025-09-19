package com.github.petstoreclean.infrastructure.adapter.web.welcome;

import com.github.petstoreclean.core.usecase.welcome.WelcomePresenterOutputPort;
import com.github.petstoreclean.infrastructure.adapter.web.AbstractWebPresenter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class WelcomePresenter extends AbstractWebPresenter implements WelcomePresenterOutputPort {

    @Override
    public void presentWelcomePage() {
        presentSuccess("welcome/home");
    }

}
