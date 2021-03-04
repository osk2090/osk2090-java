package com.osk2090.io.ex13;

public class Exam0210 {
    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, ch = '가'; i < 100; i++, ch++) {
            sb.append((char) (ch));
        }
        System.out.println(sb.toString());

        System.out.println();
    }

}