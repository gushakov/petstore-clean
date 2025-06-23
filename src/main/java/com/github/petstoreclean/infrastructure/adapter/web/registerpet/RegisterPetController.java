package com.github.petstoreclean.infrastructure.adapter.web.registerpet;

import com.github.petstoreclean.core.usecase.registerpet.PetRegistrationForm;
import com.github.petstoreclean.core.usecase.registerpet.RegisterPetInputPort;
import com.github.petstoreclean.infrastructure.adapter.web.AbstractWebController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@Slf4j
@RequestMapping(value = "/pet", produces = "text/html;charset=UTF-8")
public class RegisterPetController extends AbstractWebController {

    @PostMapping("/show-new-pet-registration-form")
    public void showNewPetRegistrationForm() {
        useCase().presentPetRegistrationForm();
    }

    @RequestMapping(value = "/register-new-pet", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public void registerNewPet(PetRegistrationForm form) {
        log.debug("[Register new pet] Form: {}", form);
        useCase().registerNewPet(form);
    }

    private RegisterPetInputPort useCase() {
        return useCase(RegisterPetInputPort.class);
    }
}
