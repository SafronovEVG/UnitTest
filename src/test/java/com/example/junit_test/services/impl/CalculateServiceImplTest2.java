package com.example.junit_test.services.impl;

import com.example.junit_test.exception.DivisionByZeroException;
import com.example.junit_test.exception.NoParametersException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;


class CalculateServiceImplTest2 {
    private static final CalculateServiceImpl CALCULATE_SERVICE = new CalculateServiceImpl();

    public static Stream<Arguments> paramForTestForSum() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(1, 1, 2),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForSum")
    public void sum(Integer num1, Integer num2, Integer num3) {
        Integer result = CALCULATE_SERVICE.sum(num1, num2);

        assertEquals(result, num3);
    }

    @ParameterizedTest
    @CsvSource(",1")
    public void sumException(Integer a, Integer b) {
        assertThrows(NoParametersException.class, () -> CALCULATE_SERVICE.sum(a, b));
    }

    public static Stream<Arguments> paramForTestForMinus() {
        return Stream.of(
                Arguments.of(3, 2, 1),
                Arguments.of(1, 1, 0),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForMinus")
    public void minus(Integer num1, Integer num2, Integer num3) {
        Integer result = CALCULATE_SERVICE.minus(num1, num2);

        assertEquals(result, num3);
    }

    @ParameterizedTest
    @CsvSource(",1")
    public void minusException(Integer a, Integer b) {
        assertThrows(NoParametersException.class, () -> CALCULATE_SERVICE.minus(a, b));
    }

    public static Stream<Arguments> paramForTestForMultiply() {
        return Stream.of(
                Arguments.of(3, 2, 6),
                Arguments.of(1, 1, 1),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForMultiply")
    public void multiply(Integer num1, Integer num2, Integer num3) {
        Integer result = CALCULATE_SERVICE.multiply(num1, num2);

        assertEquals(result, num3);
    }

    @ParameterizedTest
    @CsvSource(",1")
    public void multiplyException(Integer a, Integer b) {
        assertThrows(NoParametersException.class, () -> CALCULATE_SERVICE.sum(a, b));
    }


    public static Stream<Arguments> paramForTestForDivide() {
        return Stream.of(
                Arguments.of(6, 2, 3d),
                Arguments.of(1, 1, 1d)
        );
    }

    @ParameterizedTest
    @MethodSource("paramForTestForDivide")
    public void divide(Integer num1, Integer num2, Double num3) {
        Double result = (double) CALCULATE_SERVICE.divide(num1, num2);

        assertEquals(result, num3);
    }
    @ParameterizedTest
    @CsvSource("2,0")
    public void DivideExceptionArgument(Integer a, Integer b) {
        assertThrows(DivisionByZeroException.class, () -> CALCULATE_SERVICE.divide(a, b));
    }
    @ParameterizedTest
    @CsvSource(",1")
    public void DivideExceptionNoParameters(Integer a, Integer b) {
        assertThrows(NoParametersException.class, () -> CALCULATE_SERVICE.divide(a, b));
    }
}