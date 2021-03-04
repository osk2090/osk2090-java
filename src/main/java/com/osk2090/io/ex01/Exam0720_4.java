package com.osk2090.io.ex01;

import java.io.File;

public class Exam0720_4 {
    public static void main(String[] args) throws Exception {
        File dir = new File("temp");

        deleteFile(dir);
    }

    static void deleteFile(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                deleteFile(file);
            }
        }
        dir.delete();
    }
}