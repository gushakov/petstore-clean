package com.github.petstoreclean.core.model.petowner;

import lombok.Value;

/**
 * Value object representing a pet owner identifier.
 */
@Value
public class PetOwnerId {

    String id;

    public static PetOwnerId of(String id) {
        return new PetOwnerId(id);
    }
}