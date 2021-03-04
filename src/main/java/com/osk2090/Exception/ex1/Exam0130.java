package com.osk2090.Exception.ex1;

public class Exam0130 {
    public static void main(String[] args) {
        int result = Calculator2.compute("#", 100, 200);
        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자 입니다.");
        } else {
            System.out.println(result);
        }

        result = Calculator2.compute("-", 6, 7);

        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자 입니다.");
        } else {
            System.out.println(result);
        }
    }
}