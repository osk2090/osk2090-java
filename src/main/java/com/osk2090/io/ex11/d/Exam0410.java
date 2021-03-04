package com.osk2090.io.ex11.d;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Exam0410 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("temp/member4.data");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);

        Member member = new Member();
        member.name = "버질";
        member.age = 38;
        member.gender = true;

        out.writeObject(member);
        out.close();

        System.out.println("출력 완료");
    }
}