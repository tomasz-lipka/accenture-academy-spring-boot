package com.accenture.academy.calculator;

public class Calculator {

    public Integer add(int x, int y) throws IllegalArgumentException {
        if (x < 0 || y < 0 || x > 100 || y > 100){
            throw new IllegalArgumentException();
        }
        return x + y;
    }

    public Integer substract(int x, int y) throws IllegalArgumentException {
        if (x < 0 || y < 0 || x > 100 || y > 100){
            throw new IllegalArgumentException();
        }
        return x - y;
    }

    public Integer multiply(int x, int y) throws IllegalArgumentException {
        if (x < 1 || y < 1 || x > 30 || y > 30){
            throw new IllegalArgumentException();
        }
        return x * y;
    }

    public Integer divide(int x, int y) throws IllegalArgumentException {
        if (x < 0 || y < 1 || x > 1000 || y > 100){
            throw new IllegalArgumentException();
        }
        return x / y;
    }
}
