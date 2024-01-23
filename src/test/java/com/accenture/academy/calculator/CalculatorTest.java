package com.accenture.academy.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
        Integer result = calculator.add(0, 0);
        //Then
        Assertions.assertEquals(0, result);

        Integer result2 = calculator.add(100, 100);
        Assertions.assertEquals(200, result2);
    }

    @Test
    void whenSubtractNumbersThenReturnDiff(){
        //When
        Integer result = calculator.substract(0, 0);
        //Then
        Assertions.assertEquals(0, result);

        Integer result2 = calculator.substract(100, 100);
        Assertions.assertEquals(0, result2);
    }

    @Test
    void whenMultiplyNumbersThenReturnProduct(){
        //When
        Integer result = calculator.multiply(30, 30);
        //Then
        Assertions.assertEquals(900, result);

        Integer result2 = calculator.multiply(1, 1);
        Assertions.assertEquals(1, result2);
    }

    @Test
    void whenDivideNumbersThenReturnQuotient(){
        //When
        Integer result = calculator.divide(0, 1);
        //Then
        Assertions.assertEquals(0, result);

        Integer result2 = calculator.divide(1000, 100);
        Assertions.assertEquals(10, result2);
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

    @ParameterizedTest
    @CsvFileSource(resources = "/calculator-parameterized-test-add.csv")
    void whenAddTwoNumbersThenReturnTheirSum_CsvFileParameter(int x, int y, int expected){
        Assertions.assertEquals(calculator.add(x,y), expected);
    }

    @ParameterizedTest
    @MethodSource("argumentsMethod")
    void whenAddTwoNumbersThenReturnTheirSum_MethodParameter(int x, int y, int expected){
        Assertions.assertEquals(calculator.add(x,y), expected);
    }

    private static Stream<Arguments> argumentsMethod(){
        return Stream.of(
                Arguments.of(2,3,5),
                Arguments.of(2,8,10),
                Arguments.of(2,7,9)
        );
    }
}