package com.osk2090.ex12;

public class Exam0331 {
    interface Calculator {
        int compute(int a, int b);
    }

    static void test(Calculator calculator) {
        System.out.println(calculator.compute(100, 200));
    }

    public static void main(String[] args) {
        test(new Calculator() {
            @Override
            public int compute(int a, int b) {
                int sum = 0;
                for (int i = a; i <= b; i++) {
                    sum += i;
                }
                return sum;
            }
        });
    }
}