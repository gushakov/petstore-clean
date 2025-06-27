package com.github.petstoreclean.core.port.persistence;

import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.core.model.petowner.PetOwnerId;

import java.util.List;

public interface PersistenceOperationsOutputPort {

    List<PetOwner> obtainPetOwnersWithMatchingName(String namePart);

    PetOwner obtainPetOwnerById(PetOwnerId petOwnerId);
}
