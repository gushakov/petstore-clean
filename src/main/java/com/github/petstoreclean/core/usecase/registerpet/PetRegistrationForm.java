package com.github.petstoreclean.core.usecase.registerpet;

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

}
