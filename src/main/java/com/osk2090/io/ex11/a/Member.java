package com.osk2090.io.ex11.a;

public class Member {
    String name;
    int age;
    boolean gender;

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}