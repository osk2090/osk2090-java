package com.osk2090.basic.ex08;

import java.util.HashMap;

public class Exam0111 {
    public static void main(String[] args) {
        HashMap<Integer, Member> map = new HashMap<>();

        map.put(100, new Member("오", 20));
        map.put(200, new Member("은", 30));
        map.put(300, new Member("석", 40));
        map.put(400, new Member("옹", 50));

        System.out.println(map.get(100));
        System.out.println(map.get(200));
        System.out.println(map.get(300));
        System.out.println(map.get(400));

    }
}