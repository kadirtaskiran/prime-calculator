package com.icap.example.controller;

import com.icap.example.calculator.BasicPrimeCalculator;
import com.icap.example.calculator.ParallelPrimeCalculator;
import com.icap.example.calculator.StreamParallelPrimeCalculator;
import com.icap.example.calculator.StreamPrimeCalculator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by rvarlikli on 4/19/16.
 */
@RestController
@RequestMapping("/prime")
@Api(value = "Prime", description = "Operations about Prime Numbers")
public class PrimeController {


    @Autowired
    BasicPrimeCalculator basicPrimeCalculator;

    @Autowired
    ParallelPrimeCalculator parallelPrimeCalculator;

    @Autowired
    StreamPrimeCalculator streamPrimeCalculator;

    @Autowired
    StreamParallelPrimeCalculator streamParallelPrimeCalculator;

    @RequestMapping(value = "/basic/{number}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Get prime numbers till given number in basic mode")
    public ResponseEntity<Set> calculateBasic(@PathVariable Integer number) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<Set>(basicPrimeCalculator.findPrime(number), httpStatus);
    }

    @RequestMapping(value = "/parallel/{number}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Get prime numbers till given number in parallel mode")
    public ResponseEntity<Set> calculateParallel(@PathVariable Integer number) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<Set>(parallelPrimeCalculator.findPrime(number), httpStatus);
    }


    @RequestMapping(value = "/stream/{number}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Get prime numbers till given number in stream mode")
    public ResponseEntity<Set> calculateStream(@PathVariable Integer number) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<Set>(streamPrimeCalculator.findPrime(number), httpStatus);
    }

    @RequestMapping(value = "/stream/parallel/{number}",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Get prime numbers till given number in stream mode")
    public ResponseEntity<Set> calculateStreamParallel(@PathVariable Integer number) {
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<Set>(streamParallelPrimeCalculator.findPrime(number), httpStatus);
    }
}
