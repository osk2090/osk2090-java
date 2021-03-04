package com.osk2090.Exception.ex1;

public class Calculator {
    public static int compute(String op, int a, int b) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "%":
                return a % b;
            default:
                return -1;
        }
    }
}