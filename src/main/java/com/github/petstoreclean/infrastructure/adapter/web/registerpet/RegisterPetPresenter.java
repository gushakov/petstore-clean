package com.github.petstoreclean.infrastructure.adapter.web.registerpet;

import com.github.petstoreclean.core.usecase.registerpet.PetRegistrationForm;
import com.github.petstoreclean.core.usecase.registerpet.RegisterPetPresenterOutputPort;
import com.github.petstoreclean.infrastructure.adapter.web.AbstractWebPresenter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class RegisterPetPresenter extends AbstractWebPresenter implements RegisterPetPresenterOutputPort {
    @Override
    public void presentFormForNewPetRegistration(PetRegistrationForm form) {
        presentSuccess("pet/new-pet-registration", Map.of("petRegistrationForm", form));
    }

    @Override
    public void presentResultOfRegistrationOfNewPet() {
        presentSuccess("pet/registration-success.html");
    }
}
