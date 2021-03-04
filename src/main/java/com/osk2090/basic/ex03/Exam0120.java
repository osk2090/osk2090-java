package com.osk2090.basic.ex03;

import java.util.ArrayList;

public class Exam0120 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        System.out.println("1." + list);

        System.out.println("2." + list.get(2));

        list.add(1, "1212");

        list.set(3, "123123");
        System.out.println("3." + list);

        list.remove(1);
        System.out.println("4." + list);

        list.remove("222");
        System.out.println("5." + list);

        list.clear();
        System.out.println("6." + list);
    }
}