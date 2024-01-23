package com.accenture.academy.calculator;

public class Calculator {

    public Integer add(int x, int y){
        return x + y;
    }
    public Integer substract(int x, int y){
        return x - y;
    }
    public Integer multiply(int x, int y){
        return x * y;
    }
    public Integer divide(int x, int y) throws IllegalArgumentException {
        if(y == 0){
            throw new IllegalArgumentException("Can't divide by zero");
        }
        return x / y;
    }
}
