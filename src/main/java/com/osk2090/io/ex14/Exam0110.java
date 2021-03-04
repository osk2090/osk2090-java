package com.osk2090.io.ex14;

import java.io.FileOutputStream;

public class Exam0110 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/data.bin");
        out.write(0x55);

        out.close();

        System.out.println("출력완료");

    }
}