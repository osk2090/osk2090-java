package com.osk2090.io;

import java.io.File;

public class Exam02 implements FileFilter {
    public static void main(String[] args) {
        File testDir = new File("temp");
        File[] fileNameList = testDir.listFiles();
        for (File curFile : fileNameList) {
            System.out.println(curFile.getPath());
        }
    }

    @Override
    public boolean accept(File pathname) {
        return false;
    }
}