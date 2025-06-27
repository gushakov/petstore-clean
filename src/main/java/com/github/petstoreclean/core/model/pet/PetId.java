package com.github.petstoreclean.core.model.pet;

import lombok.Value;

/**
 * Value object representing a pet identifier.
 */
@Value
public class PetId {
    
    String id;

    public static PetId of(String id) {
        return new PetId(id);
    }
}