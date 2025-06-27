package com.github.petstoreclean.core.usecase.registerpet;

import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.core.model.petowner.PetOwnerId;
import com.github.petstoreclean.core.port.persistence.PersistenceOperationsOutputPort;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class RegisterPetUseCase implements RegisterPetInputPort {

    RegisterPetPresenterOutputPort presenter;
    PersistenceOperationsOutputPort persistenceOps;

    @Override
    public void adminInitiatesPetRegistration() {
        try {
            PetRegistrationForm form = PetRegistrationForm.builder().build();
            presenter.presentFormForNewPetRegistration(form);
        } catch (Exception e) {
            presenter.presentError(e);
        }
    }

    @Override
    public void adminSearchesForPetOwners(String petOwnerNamePart) {
        try {
            List<PetOwner> petOwners = persistenceOps.obtainPetOwnersWithMatchingName(petOwnerNamePart);
            presenter.presentResultOfSearchForPetOwners(petOwners);
        } catch (Exception e) {
            presenter.presentError(e);
        }
    }

    @Override
    public void adminSelectsPetOwnerAmongSearchResults(String petOwnerIdArg) {
        try {
            PetOwner petOwner = persistenceOps.obtainPetOwnerById(PetOwnerId.of(petOwnerIdArg));
            presenter.presentPetOwnerSelectedForNewPetRegistration(petOwner);
        } catch (Exception e) {
            presenter.presentError(e);
        }
    }

    @Override
    public void systemRegistersNewPet(PetRegistrationForm form) {
        try {
            log.debug("Will register pet: {}", form);
            presenter.presentResultOfRegistrationOfNewPet();
        } catch (Exception e) {
            presenter.presentError(e);
        }
    }
}
