package com.osk2090.io.ex04;

import java.io.FileOutputStream;

public class Exam0110 {
    public static void main(String[] args) throws Exception {
        FileOutputStream out = new FileOutputStream("temp/test3.data");

        int money = 123456;
        out.write(money);
        out.close();
        System.out.println("데이터 출력 완료");
    }
}