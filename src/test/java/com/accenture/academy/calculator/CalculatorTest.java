package com.accenture.academy.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testAdd(){
        //Given
        Calculator calculator = new Calculator();
        //When
        Integer result = calculator.add(1, 4);
        //Then
        Assertions.assertEquals(5, result);
    }

    @Test
    void testSubtract(){
        //Given
        Calculator calculator = new Calculator();
        //When
        Integer result = calculator.substract(1, 4);
        //Then
        Assertions.assertEquals(-3, result);
    }

    @Test
    void testMultiply(){
        //Given
        Calculator calculator = new Calculator();
        //When
        Integer result = calculator.multiply(1, 4);
        //Then
        Assertions.assertEquals(4, result);
    }

    @Test
    void testDivide(){
        //Given
        Calculator calculator = new Calculator();
        //When
        Integer result = calculator.divide(8, 2);
        //Then
        Assertions.assertEquals(4, result);
    }
}