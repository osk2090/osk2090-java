package com.osk2090.generic;

import java.util.ArrayList;

class Person_1 {
    String name;

    public Person_1(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person_1{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Man_1 extends Person_1 {

    public Man_1(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Man_1{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Woman_1 extends Person_1 {

    public Woman_1(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Woman_1{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class sam111 {
    public static void main(String[] args) {
        ArrayList<Person_1> list1 = new ArrayList<>();
        list1.add(new Person_1("인류"));
        printData(list1);

        System.out.println("------------------");

        ArrayList<Man_1> list2 = new ArrayList<>();
        list2.add(new Man_1("오펜하이머"));
        printData(list2);

        System.out.println("------------------");

        ArrayList<Woman_1> list3 = new ArrayList<>();
        list3.add(new Woman_1("빅토리아"));
//        printData(list3);//Man 클래스의 사우이 클래스가 아니기때문에 메소드 호출 불가
    }

    //Person 클래스와 그 하위 클래소 생성된 인스턴스만 매개변수로 전달 가능하다
    public static void printData(ArrayList<? super Man_1> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}