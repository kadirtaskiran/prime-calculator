package com.icap.example.calculator;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamParallelPrimeCalculator implements PrimeCalculator {
    @Override
    public Set<Integer> findPrime(Integer maxNumberTry) {
        validate(maxNumberTry);
        return IntStream.rangeClosed(2, maxNumberTry)
                .parallel()
                .map(i -> IntStream.rangeClosed(2,
                        (int) (Math.sqrt(i)))
                        .filter(j -> i / j * j == i).map(j -> 0)
                        .findAny().orElse(i))
                .filter(i -> i != 0)
                .mapToObj(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());
    }
}
