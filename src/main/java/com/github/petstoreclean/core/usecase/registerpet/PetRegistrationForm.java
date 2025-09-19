package com.github.petstoreclean.core.usecase.registerpet;

import com.github.petstoreclean.core.model.Validator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Builder
public class PetRegistrationForm {

    String petName;
    String kindOfAnimal;
    Integer age;
    String petOwnerId;
    String ownerFullName;
    String ownerAddress;

    public void validatePetInfoAndOwnerId() {
        Validator.notBlank(petName);
        Validator.notBlank(kindOfAnimal);
        Validator.notNegative(age);
        Validator.notNull(petOwnerId);
    }
}
