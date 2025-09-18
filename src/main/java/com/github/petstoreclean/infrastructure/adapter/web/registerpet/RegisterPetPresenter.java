package com.github.petstoreclean.infrastructure.adapter.web.registerpet;

import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.core.usecase.registerpet.PetRegistrationForm;
import com.github.petstoreclean.core.usecase.registerpet.RegisterPetPresenterOutputPort;
import com.github.petstoreclean.infrastructure.adapter.web.AbstractWebPresenter;
import com.github.petstoreclean.infrastructure.adapter.web.map.UiMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

@Component
@Scope(WebApplicationContext.SCOPE_REQUEST)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class RegisterPetPresenter extends AbstractWebPresenter implements RegisterPetPresenterOutputPort {

    UiMapper uiMapper;

    @Override
    public void presentFormForNewPetRegistration(PetRegistrationForm form) {
        presentSuccess("registerpet/new-pet-registration", Map.of("petRegistrationForm", form));
    }

    @Override
    public void presentResultOfSearchForPetOwners(List<PetOwner> petOwners) {
        presentSuccess("registerpet/matching-pet-owners",
                Map.of("petOwners", petOwners.stream()
                        .map(uiMapper::convert)
                        .toList()));
    }

    @Override
    public void presentPetOwnerSelectedForNewPetRegistration(PetOwner petOwner) {
        presentSuccess("registerpet/pet-owner-info-update", Map.of("petOwner", uiMapper.convert(petOwner)));
    }

    @Override
    public void presentFormForNewPetRegistrationWithErrors(String errorMessage) {
        presentError(errorMessage);
    }

    @Override
    public void presentResultOfRegistrationOfNewPet(Pet pet, PetOwner petOwner) {
        presentSuccess("registerpet/registration-success", Map.of("pet", uiMapper.convert(pet), "petOwner", uiMapper.convert(petOwner)));
    }
}
