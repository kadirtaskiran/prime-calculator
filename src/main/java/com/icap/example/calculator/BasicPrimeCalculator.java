package com.icap.example.calculator;

import java.util.HashSet;
import java.util.Set;


public class BasicPrimeCalculator implements PrimeCalculator {
    @Override
    public Set<Integer> findPrime(Integer maxNumberTry) {
        validate(maxNumberTry);
        Set<Integer> s = new HashSet<>();

        // The candidates to try (1 is not a prime number by definition!)
        outer:
        for (int i = 2; i <= maxNumberTry; i++) {
            // Only need to try up to sqrt(i) - see notes
            int maxJ = (int) Math.sqrt(i);

            // Our divisor candidates
            for (int j = 2; j <= maxJ; j++) {
                // If we can divide exactly by j, i is not prime
                if (i / j * j == i) {
                    continue outer;
                }
            }

            // If we got here, it's prime
            s.add(i);
        }

        return s;
    }


}

