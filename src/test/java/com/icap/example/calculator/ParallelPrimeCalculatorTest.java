package com.icap.example.calculator;

import org.junit.Test;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertTrue;

/**
 * Created by rvarlikli on 4/21/16.
 */
public class ParallelPrimeCalculatorTest {

    ParallelPrimeCalculator parallelPrimeCalculator=new ParallelPrimeCalculator();

    @Test(expected=RuntimeException.class)
    public void shouldThrowExWhenNegativeValue() throws Exception {
        parallelPrimeCalculator.findPrime(-1);
    }

    @Test(expected=RuntimeException.class)
    public void shouldThrowExWhenTooBigNumbersGiven() throws Exception {
        parallelPrimeCalculator.findPrime(100000000);
    }


    @Test
    public void testNotPrimeNumbers() throws Exception {
        assertTrue(parallelPrimeCalculator.findPrime(4).equals(newHashSet(2,3)));
        assertTrue(parallelPrimeCalculator.findPrime(6).equals(newHashSet(2,3,5)));
        assertTrue(parallelPrimeCalculator.findPrime(10).equals(newHashSet(2,3,5,7)));
        assertTrue(parallelPrimeCalculator.findPrime(20).equals(newHashSet(2,3,5,7,11,13,17,19)));
    }
}