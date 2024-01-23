package com.accenture.academy.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void prepareCalculatorForAll() {
        calculator = new Calculator();
    }

    @Test
    void whenAddNumbersThenReturnSum(){
        //Given
        Calculator calculator = new Calculator();
        //When
        Integer result = calculator.add(1, 4);
        //Then
        Assertions.assertEquals(5, result);
    }

    @Test
    void whenSubtractNumbersThenReturnDiff(){
        //When
        Integer result = calculator.substract(1, 4);
        //Then
        Assertions.assertEquals(-3, result);
    }

    @Test
    void whenMultiplyNumbersThenReturnProduct(){
        //When
        Integer result = calculator.multiply(1, 4);
        //Then
        Assertions.assertEquals(4, result);
    }

    @Test
    void whenDivideNumbersThenReturnQuotient(){
        //When
        Integer result = calculator.divide(8, 2);
        //Then
        Assertions.assertEquals(4, result);
    }
}