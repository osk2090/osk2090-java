package com.osk2090.io.ex13;

public class Exam0110 {
    public static void main(String[] args) throws Exception {
        byte[] bytes = new byte[1000];
        int size = 0;

        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                bytes[size++] = (byte) i;
            }

        }
        for (int i = 0; i < size; i++) {
            System.out.println(bytes[i] + ",");
        }
        System.out.println();
    }
}