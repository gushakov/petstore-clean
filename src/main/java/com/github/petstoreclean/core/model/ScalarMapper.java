package com.github.petstoreclean.core.model;

import com.github.petstoreclean.core.model.petowner.PetOwnerId;

public interface ScalarMapper {

    // Custom mapping methods for value objects
    default PetOwnerId convertStringToPetOwnerId(String id) {

        if (id == null) {
            return null;
        }
        return PetOwnerId.of(id);
    }

    default String convertPetOwnerIdToString(PetOwnerId petOwnerId) {
        if (petOwnerId == null) {
            return null;
        }
        return petOwnerId.asString();
    }


}
