package com.osk2090.io.ex04;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam0120 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("temp/test3.data");
        BufferedInputStream in2 = new BufferedInputStream(in);
        ObjectInputStream in3 = new ObjectInputStream(in2);

        int value = in.read();//read()로 읽는다
        in.close();
        System.out.println(value);
    }
}