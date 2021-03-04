package com.osk2090.io.ex09.step1;

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