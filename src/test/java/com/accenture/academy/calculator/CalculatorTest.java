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

    @Test
    void whenDivideByZeroThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(2,0));
    }

    @Test
    void whenAddInputsAreBelow0ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add(-1,7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add(7,-1));
    }
    @Test
    void whenAddInputsAreAbove100ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add(101,7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.add(7,101));
    }
    @Test
    void whenSubtractInputsAreBelow0ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.substract(-1,7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.substract(7,-1));
    }
    @Test
    void whenSubtractInputsAreAbove100ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.substract(101,7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.substract(7,101));
    }

    @Test
    void whenMultiplyInputsAreBelow1ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.multiply(0,7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.multiply(7,0));
    }

    @Test
    void whenMultiplyInputsAreAbove30ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.multiply(31,7));
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.multiply(7,31));
    }

    @Test
    void whenDivideFirstInputIsBelow0ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(-1,7));
    }

    @Test
    void whenDivideSecondInputIsBelow1ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(7,0));
    }

    @Test
    void whenDivideFirstInputIsAbove1000ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(1001,7));
    }
    @Test
    void whenDivideSecondInputIsAbove100ThenReturnException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.divide(7,101));
    }
}