package com.osk2090.io.ex13;

import java.io.StringWriter;

public class Exam0230 {
    public static void main(String[] args) {
        try (StringWriter out = new StringWriter()) {
            for (int i = 0, ch = '가'; i <= 100; i++, ch++) {
                out.write((char) (ch));
            }
            System.out.println("출력완료");
            System.out.println(out.toString());
            
        } catch (Exception e) {
            System.out.println("예외발생");
            e.printStackTrace();
        }
    }
}