package com.osk2090.io.ex14;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam0220 {
    public static void main(String[] args) {
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("temp/data3.bin")));
            out.writeInt(0x11223344);

        } catch (IOException e) {
            System.out.println("파일 입출력 예외발생");
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (Exception e2) {

            }
        }
        System.out.println("출력완료");
    }
}