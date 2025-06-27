package com.github.petstoreclean.infrastructure.adapter.web.registerpet;

import com.github.petstoreclean.core.usecase.registerpet.PetRegistrationForm;
import com.github.petstoreclean.core.usecase.registerpet.RegisterPetInputPort;
import com.github.petstoreclean.infrastructure.adapter.web.AbstractWebController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@ResponseBody
@Slf4j
@RequestMapping(value = "/registerpet", produces = "text/html;charset=UTF-8")
public class RegisterPetController extends AbstractWebController {

    @PostMapping("/show-new-pet-registration-form")
    public void showNewPetRegistrationForm() {
        useCase().adminInitiatesPetRegistration();
    }

    @PostMapping(value = "/find-pet-owner", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public void findPetOwner(@RequestParam("petOwnerNamePart") String petOwnerNamePart) {
        useCase().adminSearchesForPetOwners(petOwnerNamePart);
    }

    @PostMapping("/select-pet-owner")
    public void selectPetOwner(@RequestParam(value = "selectedPetOwnerId", required = false) String selectedPetOwnerId) {
        Optional.ofNullable(selectedPetOwnerId)
                .ifPresent(selectedPetOwner ->
                        useCase().adminSelectsPetOwnerAmongSearchResults(selectedPetOwnerId));
    }

    @PostMapping(value = "/register-new-pet", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public void registerNewPet(PetRegistrationForm form) {
        useCase().systemRegistersNewPet(form);
    }

    private RegisterPetInputPort useCase() {
        return useCase(RegisterPetInputPort.class);
    }
}
