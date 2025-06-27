package com.github.petstoreclean.core.port.persistence;

import com.github.petstoreclean.core.model.petowner.PetOwner;

import java.util.List;

public interface PersistenceOperationsOutputPort {

    List<PetOwner> obtainAllPetOwners();

}
