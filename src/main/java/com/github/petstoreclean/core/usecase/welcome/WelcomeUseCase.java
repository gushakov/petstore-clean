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

    @Override
    public void showPage1() {
        presenter.presentPage1();
    }

    @Override
    public void showPage2() {
        presenter.presentPage2();
    }

    @Override
    public void showError() {
        presenter.presentError(new IllegalStateException("Some error"));
    }
}
