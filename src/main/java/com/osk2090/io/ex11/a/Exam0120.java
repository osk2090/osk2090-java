package com.osk2090.io.ex11.a;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Exam0120 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("temp/member.data");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        Member member = new Member();
        member.name = dataInputStream.readUTF();
        member.age = dataInputStream.readInt();
        member.gender = dataInputStream.readBoolean();

        dataInputStream.close();

        System.out.println(member);
    }
}