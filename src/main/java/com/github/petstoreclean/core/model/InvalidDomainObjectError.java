package com.github.petstoreclean.core.model;

import com.github.petstoreclean.core.PetStoreGenericError;

public class InvalidDomainObjectError extends PetStoreGenericError {
    public InvalidDomainObjectError() {
        super();
    }

    public InvalidDomainObjectError(Throwable cause) {
        super(cause);
    }
}
