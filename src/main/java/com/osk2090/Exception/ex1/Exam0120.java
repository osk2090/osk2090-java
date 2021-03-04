package com.osk2090.Exception.ex1;

public class Exam0120 {
    public static void main(String[] args) {
        int result = Calculator.compute("#", 100, 200);
        if (result == -1) {
            System.out.println("유효하지 않는 연산자 입니다.");
        } else {
            System.out.println(result);
        }
    }
}