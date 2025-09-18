package com.github.petstoreclean.infrastructure.adapter.web.map;

import com.github.petstoreclean.core.model.ScalarMapper;
import com.github.petstoreclean.core.model.pet.Pet;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.web.common.PetOwnerVmBean;
import com.github.petstoreclean.infrastructure.adapter.web.common.PetVmBean;

public interface UiMapper extends ScalarMapper {
    PetOwnerVmBean convert(PetOwner petOwner);

    PetVmBean convert(Pet pet);

}
