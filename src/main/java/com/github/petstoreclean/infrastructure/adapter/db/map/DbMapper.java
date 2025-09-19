package com.github.petstoreclean.infrastructure.adapter.db.map;

import com.github.petstoreclean.core.model.ScalarMapper;
import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.pet.PetDbEntity;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner.PetOwnerDbEntity;

/**
 * Interface for mapping between domain models and database entities.
 */
public interface DbMapper extends ScalarMapper {

    PetOwner convert(PetOwnerDbEntity dbEntity);

    PetOwnerDbEntity convert(PetOwner petOwner);

    Pet convert(PetDbEntity dbEntity);

    PetDbEntity convert(Pet pet);
}