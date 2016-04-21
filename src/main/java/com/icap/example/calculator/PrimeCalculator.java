package com.icap.example.calculator;

import java.util.Set;


public interface PrimeCalculator {

    Set<Integer> findPrime(Integer maxNumberTry);

    default void validate(Integer maxNumberTry) {
        if (maxNumberTry < 2 || maxNumberTry > 99999999) {
            throw new RuntimeException("Not valid parameter");
        }
    }

}
