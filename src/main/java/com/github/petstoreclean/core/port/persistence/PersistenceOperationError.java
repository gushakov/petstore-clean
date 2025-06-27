package com.github.petstoreclean.core.port.persistence;

import com.github.petstoreclean.core.PetStoreGenericError;

public class PersistenceOperationError extends PetStoreGenericError {

    public PersistenceOperationError(Throwable cause) {
        super(cause);
    }
}
