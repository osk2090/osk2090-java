package com.osk2090.basic.ex04;

import java.util.LinkedList;

public class Exam0110 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");//순서대로 데이터삽입
        list.add("b");
        list.add("c");
        System.out.println("1." + list);

        System.out.println(list.get(1));//해당 인덱스 데이터 call

        list.add(1, "d");//해당 인덱스에 데이터 삽입(중간에 끼어든다)
        System.out.println("2." + list);

        list.remove(1);//해당 인덱스 데이터 삭제
        System.out.println("3." + list);

        list.clear();//전체 삭제
        System.out.println("4." + list);

    }
}