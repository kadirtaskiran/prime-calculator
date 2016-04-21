package com.icap.example.calculator;

import org.junit.Test;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertTrue;

/**
 * Created by rvarlikli on 4/19/16.
 */
public class BasicPrimeCalculatorTest {

    BasicPrimeCalculator basicPrimeCalculator = new BasicPrimeCalculator();


    @Test(expected=RuntimeException.class)
    public void shouldThrowExWhenNegativeValue() throws Exception {
        basicPrimeCalculator.findPrime(-1);
    }

    @Test(expected=RuntimeException.class)
    public void shouldThrowExWhenTooBigNumbersGiven() throws Exception {
        basicPrimeCalculator.findPrime(100000000);
    }


    @Test
    public void testNotPrimeNumbers() throws Exception {
        assertTrue(basicPrimeCalculator.findPrime(4).equals(newHashSet(2,3)));
        assertTrue(basicPrimeCalculator.findPrime(6).equals(newHashSet(2,3,5)));
        assertTrue(basicPrimeCalculator.findPrime(10).equals(newHashSet(2,3,5,7)));
        assertTrue(basicPrimeCalculator.findPrime(20).equals(newHashSet(2,3,5,7,11,13,17,19)));
    }
}