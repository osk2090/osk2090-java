package com.osk2090.io;

import java.io.File;
import java.io.FilenameFilter;

public class Exam01 {
    public static void main(String[] args) {
        File dir = new File("temp");
        File[] fileNameList = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("data");
            }
        });
        for (File curFile : fileNameList) {
            System.out.println(curFile.getPath());
        }
    }
}