package com.github.petstoreclean.core.usecase.registerpet;

public interface RegisterPetInputPort {

    void presentPetRegistrationForm();

    void registerNewPet(PetRegistrationForm form);

}
