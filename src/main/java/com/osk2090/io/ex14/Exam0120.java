package com.osk2090.io.ex14;

import java.io.FileOutputStream;
import java.io.IOException;

public class Exam0120 {
    public static void main(String[] args) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("temp/data.bin");
            out.write(0x55);

        } catch (IOException e) {
            System.out.println("파일 입출력 예외발생");
            e.printStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (Exception e2) {

            }
        }
        System.out.println("출력완료");
    }
}