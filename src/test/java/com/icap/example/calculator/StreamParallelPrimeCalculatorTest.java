package com.icap.example.calculator;

import org.junit.Test;

import static com.google.common.collect.Sets.newHashSet;
import static org.junit.Assert.assertTrue;

/**
 * Created by rvarlikli on 4/21/16.
 */
public class StreamParallelPrimeCalculatorTest {

    StreamParallelPrimeCalculator streamParallelPrimeCalculator=new StreamParallelPrimeCalculator();

    @Test(expected=RuntimeException.class)
    public void shouldThrowExWhenNegativeValue() throws Exception {
        streamParallelPrimeCalculator.findPrime(-1);
    }

    @Test(expected=RuntimeException.class)
    public void shouldThrowExWhenTooBigNumbersGiven() throws Exception {
        streamParallelPrimeCalculator.findPrime(100000000);
    }


    @Test
    public void testNotPrimeNumbers() throws Exception {
        assertTrue(streamParallelPrimeCalculator.findPrime(4).equals(newHashSet(2,3)));
        assertTrue(streamParallelPrimeCalculator.findPrime(6).equals(newHashSet(2,3,5)));
        assertTrue(streamParallelPrimeCalculator.findPrime(10).equals(newHashSet(2,3,5,7)));
        assertTrue(streamParallelPrimeCalculator.findPrime(20).equals(newHashSet(2,3,5,7,11,13,17,19)));
    }

}