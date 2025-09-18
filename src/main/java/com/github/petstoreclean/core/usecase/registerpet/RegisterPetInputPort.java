package com.github.petstoreclean.core.usecase.registerpet;

/**
 * Use case: a PetStore administrator registers a new pet with the system.
 */
public interface RegisterPetInputPort {

    /**
     * The admin initiates new pet registration. System presents an empty
     * form.
     */
    void adminInitiatesPetRegistration();

    /**
     * The admin searches for pet owners by a name (part). The system
     * displays a list of matching pet owners.
     *
     * @param petOwnerNamePart part of a pet's owner full name
     */
    void adminSearchesForPetOwners(String petOwnerNamePart);

    /**
     * The admin selects a pet owner among matching pet owners returned
     * by the search. The system updates the form with the selected pet's
     * owner information (including the ID of the owner).
     *
     * @param petOwnerIdArg ID of the selected pet owner
     */
    void adminSelectsPetOwnerAmongSearchResults(String petOwnerIdArg);

    /**
     * System registers new pet using information provided in the form
     * filled by the admin.
     *
     * @param form form with pet and pet owner information
     */
    void systemRegistersNewPet(PetRegistrationForm form);

}
