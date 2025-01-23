package com.example.junit_test.services.impl;

import com.example.junit_test.exception.DivisionByZeroException;
import com.example.junit_test.exception.NoParametersException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


class CalculateServiceImplTest2 {
    private static final CalculateServiceImpl calculateService = new CalculateServiceImpl();

    public static Stream<Arguments> paramForTestForSum() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, 1, 2),
                Arguments.of(0, 0, 0),
                Arguments.of(null, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForSum")
    public void sum(Integer num1, Integer num2, Integer num3) {
        try {
            Integer result = calculateService.sum(num1, num2);
            assertEquals(result, num3);
        } catch (NoParametersException e) {
            assertThrows(NoParametersException.class, () -> calculateService.sum(num1, num2));
        }
    }

    public static Stream<Arguments> paramForTestForMinus() {
        return Stream.of(
                Arguments.of(3, 2, 1),
                Arguments.of(1, 1, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(null, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForMinus")
    public void minus(Integer num1, Integer num2, Integer num3) {
        try {
            Integer result = calculateService.minus(num1, num2);
            assertEquals(result, num3);
        } catch (NoParametersException e) {
            assertThrows(NoParametersException.class, () -> calculateService.minus(num1, num2));
        }
    }

    public static Stream<Arguments> paramForTestForMultiply() {
        return Stream.of(
                Arguments.of(3, 2, 6),
                Arguments.of(1, 1, 1),
                Arguments.of(0, 0, 0),
                Arguments.of(null, null, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForMultiply")
    public void multiply(Integer num1, Integer num2, Integer num3) {
        try {
            Integer result = calculateService.multiply(num1, num2);
            assertEquals(result, num3);
        } catch (NoParametersException e) {
            assertThrows(NoParametersException.class, () -> calculateService.multiply(num1, num2));
        }
    }

    public static Stream<Arguments> paramForTestForDivide() {
        return Stream.of(
                Arguments.of(6, 2, 3d),
                Arguments.of(1, 1, 1d),
                Arguments.of(0, 0, 0d),
                Arguments.of(null, 1, 2d)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForDivide")
    public void divide(Integer num1, Integer num2, Double num3) {
        try {
            Double result = (double) calculateService.divide(num1, num2);
            assertEquals(result, num3);
        } catch (DivisionByZeroException e) {
            assertThrows(DivisionByZeroException.class, () -> calculateService.divide(num1, num2));
        } catch (NoParametersException e) {
            assertThrows(NoParametersException.class, () -> calculateService.divide(num1, num2));
        }
    }
}