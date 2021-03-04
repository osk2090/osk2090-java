package com.osk2090.Exception;

public class Exam0110 {
    public static void main(String[] args) {
        try {
            int result = 100 / 0;
            System.out.printf("계산 결과 = %d\n", result);
        } catch (Throwable e) {
            System.out.println("나누기 연산 중 오류 발생!");
        }
    }
}