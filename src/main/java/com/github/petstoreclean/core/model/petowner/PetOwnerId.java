package com.github.petstoreclean.core.model.petowner;

import com.github.petstoreclean.core.model.Validator;
import lombok.Builder;
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

    @Builder
    private PetOwnerId(String id) {
        this.id = Validator.notBlank(id);
    }

    public String asString() {
        return id;
    }
}