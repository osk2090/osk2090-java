package com.osk2090.io.ex11.a;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Exam0110 {
    public static void main(String[] args) throws Exception {

        FileOutputStream fileOutputStream = new FileOutputStream("temp/member.data");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        Member member = new Member();
        member.name = "오은석";
        member.age = 29;
        member.gender = true;

        dataOutputStream.writeUTF(member.name);
        dataOutputStream.writeInt(member.age);
        dataOutputStream.writeBoolean(member.gender);

        dataOutputStream.close();
        System.out.println("데이터 출력완료!");

    }
}