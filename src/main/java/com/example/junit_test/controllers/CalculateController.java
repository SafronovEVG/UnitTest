package com.example.junit_test.controllers;

import com.example.junit_test.exception.DivisionByZeroException;
import com.example.junit_test.exception.NoParametersException;
import com.example.junit_test.services.api.CalculateService;
import com.example.junit_test.services.impl.CalculateServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculateController {
    private final CalculateService calculateService;

    public CalculateController(CalculateServiceImpl calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public String showGreeting() {
        return calculateService.showGreeting();
    }

    @GetMapping("/plus")
    public Integer sum(@RequestParam Integer num1, @RequestParam Integer num2) {
        try {
            return calculateService.sum(num1, num2);
        } catch (NoParametersException e) {
            throw new NoParametersException();
        }
    }

    @GetMapping("/minus")
    public Integer minus(@RequestParam Integer num1, @RequestParam Integer num2) {
        try {
            return calculateService.minus(num1, num2);
        } catch (NoParametersException e) {
            throw new NoParametersException();
        }
    }

    @GetMapping("/multiply")
    public Integer multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
        try {
            return calculateService.multiply(num1, num2);
        } catch (NoParametersException e) {
            throw new NoParametersException();
        }
    }

    @GetMapping("/divide")
    public Double divide(@RequestParam Integer num1, @RequestParam Integer num2) {
        try {
            return calculateService.divide(num1, num2);
        } catch (NoParametersException e) {
            throw new NoParametersException();
        } catch (DivisionByZeroException e) {
            throw new DivisionByZeroException();
        }
    }
}

