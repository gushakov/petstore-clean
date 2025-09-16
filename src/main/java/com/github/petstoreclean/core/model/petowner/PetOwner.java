package com.github.petstoreclean.core.model.petowner;

import com.github.petstoreclean.core.model.Validator;
import lombok.Builder;
import lombok.Value;

/**
 * Domain model representing a pet owner.
 */
@Value
public class PetOwner {

    PetOwnerId id;
    String name;
    String address;
    Integer version;

    @Builder
    public PetOwner(PetOwnerId id, String name, String address, Integer version) {
        this.id = Validator.notNull(id);
        this.name = Validator.notBlank(name);
        this.address = Validator.notBlank(address);

        // could be null when creating a new pet owner
        this.version = version;
    }
}