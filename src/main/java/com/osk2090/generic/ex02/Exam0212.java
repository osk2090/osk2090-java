package com.osk2090.generic.ex02;

import java.util.ArrayList;

public class Exam0212 {
    public static void main(String[] args) {
        ArrayList<Object> list;

        list = new ArrayList();
        list = new ArrayList<>();
        list = new ArrayList<Object>();

        list.add(new String());
        list.add(new Integer(1000));
        list.add(new java.util.Date());
        list.add(new Member("오은석", 29));

        
    }
}