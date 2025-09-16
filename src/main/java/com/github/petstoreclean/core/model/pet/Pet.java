package com.github.petstoreclean.core.model.pet;

import com.github.petstoreclean.core.model.Validator;
import com.github.petstoreclean.core.model.petowner.PetOwnerId;
import lombok.Builder;
import lombok.Value;

/**
 * Domain model representing a pet.
 */
@Value
@Builder
public class Pet {

    PetId petId;
    String name;
    String kindOfAnimal;
    Integer age;
    PetOwnerId petOwnerId;
    Integer version;

    @Builder
    private Pet(PetId petId, String name, String kindOfAnimal, Integer age, PetOwnerId petOwnerId, Integer version) {
        this.petId = Validator.notNull(petId);
        this.name = Validator.notBlank(name);
        this.kindOfAnimal = Validator.notBlank(kindOfAnimal);
        this.age = Validator.notNull(age);
        this.petOwnerId = Validator.notNull(petOwnerId);
        this.version = version;
    }

}
