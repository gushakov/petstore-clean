package com.github.petstoreclean.core.usecase.registerpet;

import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.web.ErrorHandlingPresenterOutputPort;

import java.util.List;

public interface RegisterPetPresenterOutputPort extends ErrorHandlingPresenterOutputPort {
    void presentFormForNewPetRegistration(PetRegistrationForm form);

    void presentResultOfSearchForPetOwners(List<PetOwner> petOwners);

    void presentPetOwnerSelectedForNewPetRegistration(PetOwner petOwner);

    void presentFormForNewPetRegistrationWithErrors(PetRegistrationForm form, String errorMessage);

    void presentResultOfRegistrationOfNewPet();
}
