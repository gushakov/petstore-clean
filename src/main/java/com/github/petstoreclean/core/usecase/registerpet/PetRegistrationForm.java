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
    String ownerFullName;
    String ownerAddress;

    public void validate() {
        Validator.notBlank(petName);
        Validator.notBlank(kindOfAnimal);
        Validator.notNull(age);
        if (age <= 0) {
            throw new IllegalArgumentException("Pet age must be a positive number.");
        }
        Validator.notBlank(ownerFullName);
        Validator.notBlank(ownerAddress);
    }
}
