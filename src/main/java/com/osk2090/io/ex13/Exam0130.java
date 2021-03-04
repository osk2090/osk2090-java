package com.osk2090.io.ex13;

import java.io.ByteArrayOutputStream;

public class Exam0130 {
    public static void main(String[] args) {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0) {
                    out.write(i);
                }
            }
            System.out.println("완료");
            byte[] bytes = out.toByteArray();
            for (byte b : bytes) {
                System.out.println(b + ",");
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("파일 출력 예외 발생");
            e.printStackTrace();
        }
    }
}