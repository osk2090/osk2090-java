package com.osk2090.Exception.ex1;

public class Exam0121 {
    public static void main(String[] args) {
        int result = Calculator.compute("-", 6, 7);

        if (result == -1) {
            System.out.println("유효하지 않은 연산자입니다.");
        } else {
            System.out.println(result);
        }
    }
}