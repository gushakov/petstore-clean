package com.github.petstoreclean.infrastructure.adapter.db.map;

import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner.PetOwnerDbEntity;

/**
 * Interface for mapping between domain models and database entities.
 */
public interface DbMapper {

    /**
     * Converts database entity to domain model.
     *
     * @param dbEntity database entity
     * @return domain model
     */
    PetOwner convert(PetOwnerDbEntity dbEntity);

    /**
     * Converts domain model to database entity.
     *
     * @param petOwner domain model
     * @return database entity
     */
    PetOwnerDbEntity convert(PetOwner petOwner);
}