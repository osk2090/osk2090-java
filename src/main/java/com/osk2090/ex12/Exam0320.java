package com.osk2090.ex12;

public class Exam0320 {
    static interface Calculator {
        int compute(int a, int b);
    }

    static void test(Calculator calculator) {
        System.out.println(calculator.compute(100, 200));
    }

    public static void main(String[] args) {
        test((a, b) -> a + b);
    }
}