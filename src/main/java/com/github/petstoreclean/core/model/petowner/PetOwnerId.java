package com.github.petstoreclean.core.model.petowner;

import lombok.Value;

import java.util.UUID;

/**
 * Value object representing a pet owner identifier.
 */
@Value
public class PetOwnerId {
    
    String id;

    public static PetOwnerId generate() {
        return new PetOwnerId(UUID.randomUUID().toString());
    }

    public static PetOwnerId of(String id) {
        return new PetOwnerId(id);
    }
}