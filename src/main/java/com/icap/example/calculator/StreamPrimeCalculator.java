package com.icap.example.calculator;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by rvarlikli on 4/19/16.
 */
public class StreamPrimeCalculator implements PrimeCalculator {
    @Override
    public Set<Integer> findPrime(Integer maxNumberTry) {
        validate(maxNumberTry);
        Set<Integer> s = IntStream.rangeClosed(2, maxNumberTry)
                .map(i -> IntStream.rangeClosed(2,
                        (int) (Math.sqrt(i)))
                        .filter(j -> i / j * j == i).map(j -> 0)
                        .findAny().orElse(i))
                .filter(i -> i != 0)
                .mapToObj(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());
    return s;
    }

}
