package com.icap.example;

import com.icap.example.calculator.BasicPrimeCalculator;
import com.icap.example.calculator.ParallelPrimeCalculator;
import com.icap.example.calculator.StreamParallelPrimeCalculator;
import com.icap.example.calculator.StreamPrimeCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public BasicPrimeCalculator basicPrimeCalculator() {
        return new BasicPrimeCalculator();
    }

    @Bean
    public ParallelPrimeCalculator parallelPrimeCalculator() {
        return new ParallelPrimeCalculator();
    }

    @Bean
    public StreamPrimeCalculator streamPrimeCalculator() {return new StreamPrimeCalculator();}

    @Bean
    public StreamParallelPrimeCalculator streamParallelPrimeCalculator() {return new StreamParallelPrimeCalculator();}
}
