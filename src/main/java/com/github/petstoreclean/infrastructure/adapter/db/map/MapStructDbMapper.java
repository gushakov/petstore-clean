package com.github.petstoreclean.infrastructure.adapter.db.map;

import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.db.jdbc.petowner.PetOwnerDbEntity;
import com.github.petstoreclean.infrastructure.map.IgnoreForMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class MapStructDbMapper implements DbMapper {

    @Mapping(target = "petOwnerId", source = "id")
    protected abstract PetOwner map(PetOwnerDbEntity dbEntity);

    @Mapping(target = "id", source = "petOwnerId")
    protected abstract PetOwnerDbEntity map(PetOwner petOwner);

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
}