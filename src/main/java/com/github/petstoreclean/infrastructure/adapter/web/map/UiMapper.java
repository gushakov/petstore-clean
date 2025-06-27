package com.github.petstoreclean.infrastructure.adapter.web.map;

import com.github.petstoreclean.core.model.ScalarMapper;
import com.github.petstoreclean.core.model.petowner.PetOwner;
import com.github.petstoreclean.infrastructure.adapter.web.common.PetOwnerVmBean;

public interface UiMapper extends ScalarMapper {
    PetOwnerVmBean convert(PetOwner petOwner);
}
