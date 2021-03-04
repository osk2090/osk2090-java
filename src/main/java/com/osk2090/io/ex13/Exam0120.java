package com.osk2090.io.ex13;

import java.io.FileOutputStream;

public class Exam0120 {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("temp/data.bin")) {
            for (int i = 0; i <= 100; i++) {
                if (i % 2 == 0) {
                    out.write(i);
                }
            }
            System.out.println("완료");
        } catch (Exception e) {
            System.out.println("파일 출력 예외발생");
            e.printStackTrace();
        }
    }
}