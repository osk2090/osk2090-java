package com.osk2090.io.ex11.c;

public class Member implements java.io.Serializable {
    String name;
    int age;
    boolean gender;
    int tel;

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", tel=" + tel +
                '}';
    }
}