package com.github.petstoreclean.core.port.id;

import com.github.petstoreclean.core.model.id.IdPrefixes;

/**
 * Output port for generating unique identifiers.
 */
public interface IdsOperationsOutputPort {

    /**
     * Generates a new unique identifier with the specified prefix.
     *
     * @param prefix three-letter prefix to distinguish different model types
     * @return unique identifier string in format "prefix_XXXXXX"
     */
    String generateId(String prefix);

    default String generatePetOwnerId(){
        return generateId(IdPrefixes.PET_OWNER);
    }
}