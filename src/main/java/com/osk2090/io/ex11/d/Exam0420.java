package com.osk2090.io.ex11.d;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam0420 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/member4.data");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Member member = (Member) in.readObject();
        in.close();
        System.out.println(member);

    }

    /*
    결론
    Member 객체를 serialize 한 후
    필드를 추가하거나 삭제하더라도
    serialVersionUID 값만 같으면
    JVM 같은 형식으로 판단한다
     */
}