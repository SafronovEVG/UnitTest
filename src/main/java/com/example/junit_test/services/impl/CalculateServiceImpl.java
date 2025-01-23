package com.example.junit_test.services.impl;

import com.example.junit_test.exception.DivisionByZeroException;
import com.example.junit_test.exception.NoParametersException;
import com.example.junit_test.services.api.CalculateService;
import org.springframework.stereotype.Service;

@Service
public class CalculateServiceImpl implements CalculateService {

    @Override
    public String showGreeting() {
        return "Добро пожаловать в калькулятор";
    }

    @Override
    public Integer sum(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NoParametersException();
        }
        return a + b;
    }

    @Override
    public Integer minus(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NoParametersException("Pidor");
        }
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NoParametersException();
        }
        return a * b;
    }

    @Override
    public Double divide(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NoParametersException();
        } else if (b == 0) {
            throw new DivisionByZeroException(" Деление на 0 запрещено!");
        }
        return (double) a / b;
    }


}
