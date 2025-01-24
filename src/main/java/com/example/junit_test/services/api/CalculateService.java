package com.example.junit_test.services.api;

public interface CalculateService {
    String showGreeting();

    Integer sum(Integer a, Integer b);

    Integer minus(Integer a, Integer b);

    Integer multiply(Integer a, Integer b);

    Double divide(Integer a, Integer b);
}
