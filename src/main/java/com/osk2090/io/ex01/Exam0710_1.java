package com.osk2090.io.ex01;

import java.io.File;

public class Exam0710_1 {
    public static void main(String[] args) throws Exception {
        File dir = new File(".");
        System.out.println(dir.getCanonicalPath());

    }
}