package com.github.petstoreclean.infrastructure.utils;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtils {

    public static <T> Stream<T> stream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

}
