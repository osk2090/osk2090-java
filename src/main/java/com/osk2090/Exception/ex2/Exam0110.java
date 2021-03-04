package com.osk2090.Exception.ex2;

public class Exam0110 {
    public static void main(String[] args) {
        String op = "#";
        int a = 100;
        int b = 200;

        try {
            int result = Calculator3.compute(op, a, b);
            System.out.println(result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}