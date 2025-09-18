package com.github.petstoreclean.core.usecase.registerpet;

import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.core.model.petowner.PetOwnerId;
import com.github.petstoreclean.core.port.id.IdsOperationsOutputPort;
import com.github.petstoreclean.core.port.persistence.PersistenceOperationsOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterPetUseCaseTest {

    @Mock
    private RegisterPetPresenterOutputPort presenter;
    @Mock
    private PersistenceOperationsOutputPort persistenceOps;
    @Mock
    private IdsOperationsOutputPort idsOps;

    private RegisterPetUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new RegisterPetUseCase(presenter, persistenceOps, idsOps);
    }

    @Test
    void adminInitiatesPetRegistration_shouldPresentForm() {
        useCase.adminInitiatesPetRegistration();
        verify(presenter).presentFormForNewPetRegistration(any(PetRegistrationForm.class));
    }

    @Test
    void adminSearchesForPetOwners_shouldPresentSearchResults() {
        List<PetOwner> petOwners = Collections.singletonList(PetOwner.builder().id(PetOwnerId.of("PO_1")).name("John Doe").address("123 Main St").version(0).build());
        when(persistenceOps.obtainPetOwnersWithMatchingName("John")).thenReturn(petOwners);

        useCase.adminSearchesForPetOwners("John");

        verify(persistenceOps).obtainPetOwnersWithMatchingName("John");
        verify(presenter).presentResultOfSearchForPetOwners(petOwners);
    }

    @Test
    void adminSelectsPetOwnerAmongSearchResults_shouldPresentSelectedPetOwner() {
        PetOwner petOwner = PetOwner.builder().id(PetOwnerId.of("PO_1")).name("John Doe").address("123 Main St").version(0).build();
        when(persistenceOps.obtainPetOwnerById(PetOwnerId.of("PO_1"))).thenReturn(petOwner);

        useCase.adminSelectsPetOwnerAmongSearchResults("PO_1");

        verify(persistenceOps).obtainPetOwnerById(PetOwnerId.of("PO_1"));
        verify(presenter).presentPetOwnerSelectedForNewPetRegistration(petOwner);
    }

    @Test
    void systemRegistersNewPet_withExistingPetOwner_shouldSavePetOnly() {
        String existingPetOwnerId = "PO_EXISTING";
        PetRegistrationForm form = PetRegistrationForm.builder()
                .petName("Whiskers")
                .kindOfAnimal("Cat")
                .age(2)
                .petOwnerId(existingPetOwnerId)
                .build();

        when(idsOps.generatePetId()).thenReturn("PET_NEW_2");
        // We need to mock the petOwner retrieval for the presenter call
        PetOwner existingPetOwner = PetOwner.builder().id(PetOwnerId.of(existingPetOwnerId)).name("Existing Owner").address("789 Pine St").version(0).build();
        when(persistenceOps.obtainPetOwnerById(PetOwnerId.of(existingPetOwnerId))).thenReturn(existingPetOwner);

        useCase.systemRegistersNewPet(form);

        ArgumentCaptor<Pet> petCaptor = ArgumentCaptor.forClass(Pet.class);
        verify(persistenceOps).savePet(petCaptor.capture());
        Pet savedPet = petCaptor.getValue();
        assertThat(savedPet.getId().getId()).isEqualTo("PET_NEW_2");
        assertThat(savedPet.getPetOwnerId().getId()).isEqualTo(existingPetOwnerId);

        verify(presenter).presentResultOfRegistrationOfNewPet(savedPet, existingPetOwner);
    }

}