package com.github.petstoreclean.core.usecase.welcome;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WelcomeUseCase implements WelcomeInputPort {

    WelcomePresenterOutputPort presenter;

    @Override
    public void visitWelcomePage() {
        presenter.presentWelcomePage();
    }

}
