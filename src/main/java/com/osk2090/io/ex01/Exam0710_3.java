package com.osk2090.io.ex01;

import java.io.File;

public class Exam0710_3 {
    public static void main(String[] args) throws Exception {
        File dir = new File(".");
        System.out.println(dir.getCanonicalPath());

        printList(dir);
    }

    static void printList(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}