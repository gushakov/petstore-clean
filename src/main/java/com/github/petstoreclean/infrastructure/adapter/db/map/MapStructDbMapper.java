package com.github.petstoreclean.infrastructure.adapter.db.map;

import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.pet.PetDbEntity;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner.PetOwnerDbEntity;
import com.github.petstoreclean.infrastructure.map.IgnoreForMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class MapStructDbMapper implements DbMapper {

    @Mapping(source = "id", target = "id")
    protected abstract PetOwner map(PetOwnerDbEntity dbEntity);

    @Mapping(source = "id.id", target = "id")
    protected abstract PetOwnerDbEntity map(PetOwner petOwner);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "petOwnerId", target = "petOwnerId")
    protected abstract Pet map(PetDbEntity dbEntity);

    @Mapping(source = "id.id", target = "id")
    @Mapping(source = "petOwnerId.id", target = "petOwnerId")
    protected abstract PetDbEntity map(Pet pet);

    @IgnoreForMapping
    @Override
    public PetOwner convert(PetOwnerDbEntity dbEntity) {
        return map(dbEntity);
    }

    @IgnoreForMapping
    @Override
    public PetOwnerDbEntity convert(PetOwner petOwner) {
        return map(petOwner);
    }

    @IgnoreForMapping
    @Override
    public Pet convert(PetDbEntity dbEntity) {
        return map(dbEntity);
    }

    @IgnoreForMapping
    @Override
    public PetDbEntity convert(Pet pet) {
        return map(pet);
    }
}