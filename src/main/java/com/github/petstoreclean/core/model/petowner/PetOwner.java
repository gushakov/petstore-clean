package com.github.petstoreclean.core.model.petowner;

import lombok.Value;

/**
 * Domain model representing a pet owner.
 */
@Value
public class PetOwner {

    PetOwnerId petOwnerId;
    String name;
    String address;
    Integer version;

    public static PetOwner create(PetOwnerId petOwnerId, String name, String address) {
        return new PetOwner(petOwnerId, name, address, null);
    }

    public PetOwner updateInfo(String name, String address) {
        return new PetOwner(this.petOwnerId, name, address, this.version);
    }
}