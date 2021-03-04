package com.osk2090.ex12;

public class Exam0321 {
    static interface Calculator {
        int compute(int a, int b);
    }

    static void test(Calculator calculator) {
        System.out.println(calculator.compute(100, 200));
    }

    public static void main(String[] args) {
        test(new Calculator() {
            @Override
            public int compute(int a, int b) {
                return a + b;
            }
        });
    }
}