package com.github.petstoreclean.infrastructure.adapter.id;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.github.petstoreclean.core.port.id.IdGeneratorOutputPort;
import org.springframework.stereotype.Service;

/**
 * Secondary adapter for generating unique identifiers using JNanoID.
 */
@Service
public class JNanoIdGenerator implements IdGeneratorOutputPort {

    private static final char[] ALPHABET = 
        "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    
    private static final int ID_LENGTH = 6;

    @Override
    public String generateId(String prefix) {
        String nanoId = NanoIdUtils.randomNanoId(NanoIdUtils.DEFAULT_NUMBER_GENERATOR, ALPHABET, ID_LENGTH);
        return prefix + "_" + nanoId;
    }
}