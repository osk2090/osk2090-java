package com.osk2090.io.ex11.e;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam0510 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/score.data");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        Score score = new Score();
        score.name = "버질";
        score.kor = 55;
        score.eng = 60;
        score.math = 77;

        score.sum = 100;
        score.aver = 50.0f;

        out.writeObject(score);
        out.close();
        System.out.println("출력 완료");
    }
}