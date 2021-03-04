package com.osk2090.generic;

import java.util.ArrayList;

// Person 상속X 클래스
class Test {
    String name;

}

// Person 클래스
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

// Person 상속 Man 클래스
class Man extends Person {
    // 생성자
    Man(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }
}

// Person 상속 Woman 클래스
class Woman extends Person {
    Woman(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Woman{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class sam {
    public static void main(String[] args) {
        ArrayList<Person> list1 = new ArrayList<>();
        list1.add(new Person("아인슈타인"));
        printData(list1);

        System.out.println("------------------");

        ArrayList<Man> list2 = new ArrayList<>();
        list2.add(new Man("게이브 뉴웰"));
        printData(list2);

        System.out.println("------------------");

        ArrayList<Woman> list3 = new ArrayList<>();
        list3.add(new Woman("퀴리 부인"));
        printData(list3);
    }

    //Person 클래스와 그 하위 클래소 생성된 인스턴스만 매개변수로 전달 가능하다
    public static void printData(ArrayList<? extends Person> list) {
        for (Person p : list) {
            System.out.println(p);
        }
    }
}