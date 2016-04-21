package com.icap.example.calculator;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


public class ParallelPrimeCalculator implements PrimeCalculator {
    private static Integer workSize;
    private static Queue<Results> resultsQueue;

    @Override
    public Set<Integer> findPrime(Integer maxNumberTry) {
        validate(maxNumberTry);
        Set calculatedPrimeNumbers = new HashSet<>();
        workSize = (int) Math.sqrt(maxNumberTry);
        ForkJoinPool pool = new ForkJoinPool();
        resultsQueue = new ConcurrentLinkedQueue<>();
        pool.invoke(new FindPrimes(2, maxNumberTry));
        while (resultsQueue.size() > 0) {
            Results results = resultsQueue.poll();
            calculatedPrimeNumbers.addAll(results.resultSet);
        }
        return calculatedPrimeNumbers;
    }



    private static class FindPrimes extends RecursiveAction {
        private final int start;
        private final int end;

        public FindPrimes(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private Set<Integer> findPrimes(int minPrimeTry, int maxPrimeTry) {
            Set<Integer> s = new HashSet<>();
            outer:
                for (int i = minPrimeTry; i <= maxPrimeTry; i++) {
                    int maxJ = (int) Math.sqrt(i);
                    for (int j = 2; j <= maxJ; j++) {
                        if (i / j * j == i) {
                            continue outer;
                        }
                    }
                    s.add(i);
                }
            return s;
        }

        protected void compute() {
            if (end - start < workSize) {
                resultsQueue.offer(new Results(start, end, findPrimes(start, end)));
            } else {
                int mid = (start + end) / 2;
                invokeAll(new FindPrimes(start, mid), new FindPrimes(mid + 1, end));
            }
        }
    }
    private static class Results {
        public final int minPrimeTry;
        public final int maxPrimeTry;
        public final Set resultSet;

        public Results(int minPrimeTry, int maxPrimeTry, Set resultSet) {
            this.minPrimeTry = minPrimeTry;
            this.maxPrimeTry = maxPrimeTry;
            this.resultSet = resultSet;
        }
    }

}


