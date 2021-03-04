package com.osk2090.io.ex13;

import java.io.FileWriter;

public class Exam0220 {
    public static void main(String[] args) {
        try (FileWriter out = new FileWriter("temp/data.txt")) {
            for (int i = 0, ch = '가'; i <= 100; i++, ch++) {
                out.write((char) (ch));
            }
            System.out.println("출력완료");
        } catch (Exception e) {
            System.out.println("파일 출력 예외 발생");
            e.printStackTrace();
        }
    }
}