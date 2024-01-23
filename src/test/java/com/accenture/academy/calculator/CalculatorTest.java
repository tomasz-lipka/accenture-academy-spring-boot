package com.accenture.academy.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}