package com.example.junit_test.services.impl;

import com.example.junit_test.exception.DivisionByZeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceImplTest {
    private Integer a;
    private Integer b;
    private Integer y;
    private String greeting;
    private CalculateServiceImpl calculateService;

    @BeforeEach
    public void setUp() {
        calculateService = new CalculateServiceImpl();
        greeting = "Добро пожаловать в калькулятор";
        a = 1;
        b = 2;
        y = 0;
    }

    @Test
    public void hello() {

        assertEquals(greeting, calculateService.showGreeting());
    }

    @Test
    public void sum() {
        Integer extended = a + b;

        Integer actual = calculateService.sum(a, b);

        assertEquals(extended, actual);
    }

    @Test
    public void minus() {
        Integer extended = a - b;

        Integer actual = calculateService.minus(a, b);

        assertEquals(extended, actual);
    }

    @Test
    public void multiply() {
        Integer extended = a * b;

        Integer actual = calculateService.multiply(a, b);

        assertEquals(extended, actual);
    }

    @Test
    public void divide() {
        assertThrows(DivisionByZeroException.class, () -> calculateService.divide(a, y));
    }

    @Test
    public void divideNoException() {
        double extended = (double) a / b;

        double actual = calculateService.divide(a, b);

        assertEquals(extended, actual);
    }

}