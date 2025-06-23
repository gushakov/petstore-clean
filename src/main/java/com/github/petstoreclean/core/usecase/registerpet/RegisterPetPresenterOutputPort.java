package com.github.petstoreclean.core.usecase.registerpet;

import com.github.petstoreclean.infrastructure.adapter.web.ErrorHandlingPresenterOutputPort;

public interface RegisterPetPresenterOutputPort extends ErrorHandlingPresenterOutputPort {
    void presentFormForNewPetRegistration(PetRegistrationForm form);

    void presentResultOfRegistrationOfNewPet();

}
