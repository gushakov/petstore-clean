package com.github.petstoreclean.core.usecase.registerpet;

import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.pet.PetId;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.core.model.petowner.PetOwnerId;
import com.github.petstoreclean.core.port.id.IdsOperationsOutputPort;
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
    IdsOperationsOutputPort idsOps;

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

            // Validate form data
            try {
                form.validatePetInfoAndOwnerId();
            } catch (Exception e) {
                presenter.presentFormForNewPetRegistrationWithErrors("Form data is not valid");
                return;
            }

            log.debug("Will register pet: {}", form);

            PetOwnerId petOwnerId = PetOwnerId.of(form.getPetOwnerId());
            Pet newPet = Pet.builder()
                    .id(PetId.of(idsOps.generatePetId()))
                    .name(form.getPetName())
                    .kindOfAnimal(form.getKindOfAnimal())
                    .age(form.getAge())
                    .petOwnerId(petOwnerId)
                    .version(0)
                    .build();
            persistenceOps.savePet(newPet);

            // load pet owner for presentation
            PetOwner petOwner = persistenceOps.obtainPetOwnerById(petOwnerId);

            presenter.presentResultOfRegistrationOfNewPet(newPet, petOwner);
        } catch (Exception e) {
            presenter.presentError(e);
        }
    }
}
