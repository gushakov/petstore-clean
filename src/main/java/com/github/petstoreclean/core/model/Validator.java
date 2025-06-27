package com.github.petstoreclean.core.model;

public class Validator {

    public static <T> T notNull(T obj) {
        if (obj == null) {
            throw new InvalidDomainObjectError();
        }
        return obj;
    }

    public static String notBlank(String text) {
        if (notNull(text).isBlank()) {
            throw new InvalidDomainObjectError();
        }
        return text;
    }

}
