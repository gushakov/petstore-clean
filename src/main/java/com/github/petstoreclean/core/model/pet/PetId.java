package com.github.petstoreclean.core.model.pet;

import lombok.Builder;
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

    @Builder
    private PetId(String id) {
        this.id = id;
    }

    public String asString() {
        return id;
    }
}