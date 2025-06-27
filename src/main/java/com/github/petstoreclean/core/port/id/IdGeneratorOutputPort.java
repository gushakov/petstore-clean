package com.github.petstoreclean.core.port.id;

/**
 * Output port for generating unique identifiers.
 */
public interface IdGeneratorOutputPort {

    /**
     * Generates a new unique identifier with the specified prefix.
     *
     * @param prefix three-letter prefix to distinguish different model types
     * @return unique identifier string in format "prefix_XXXXXX"
     */
    String generateId(String prefix);
}