package com.github.petstoreclean.core.usecase.registerpet;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class RegisterPetUseCase implements RegisterPetInputPort {

    RegisterPetPresenterOutputPort presenter;

    @Override
    public void presentPetRegistrationForm() {
        try {
            PetRegistrationForm form = PetRegistrationForm.builder().build();
            presenter.presentFormForNewPetRegistration(form);
        }
        catch (Exception e) {
            presenter.presentError(e);
        }
    }

    @Override
    public void registerNewPet(PetRegistrationForm form) {
        try {
            presenter.presentResultOfRegistrationOfNewPet();
        }
        catch (Exception e) {
            presenter.presentError(e);
        }
    }
}
