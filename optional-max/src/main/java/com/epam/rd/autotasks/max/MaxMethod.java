package com.epam.rd.autotasks.max;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxMethod {
    public static OptionalInt max(int[] values) {

//        if (values == null) throw new UnsupportedOperationException();

        OptionalInt max;

        if (values != null && values.length >0) max = IntStream.of(values).max();
        else max = OptionalInt.empty();

        return max;
    }
}
