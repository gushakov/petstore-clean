package com.github.petstoreclean.infrastructure.adapter.web.map;

import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.web.common.PetOwnerVmBean;
import com.github.petstoreclean.infrastructure.map.IgnoreForMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MapStructUiMapper implements UiMapper {

    protected abstract PetOwnerVmBean map(PetOwner petOwner);

    @IgnoreForMapping
    @Override
    public PetOwnerVmBean convert(PetOwner petOwner) {
        return map(petOwner);
    }
}
