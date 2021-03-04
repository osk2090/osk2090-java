package com.osk2090.ex12;

import java.util.function.Predicate;

public class Exam0630 {
    public static void main(String[] args) {
        class MyPredicate<T> implements Predicate<T> {
            @Override
            public boolean test(T value) {
                return ((String) value).isEmpty();
            }
        }
        Predicate<String> p1 = new MyPredicate<>();

        Predicate<String> p2 = new Predicate<String>() {
            @Override
            public boolean test(String value) {
                return value.isEmpty();
            }
        };

        Predicate<String> p3 = value -> value.isEmpty();
        Predicate<String> p4 = String::isEmpty;

//        Predicate<String> p = value -> value.isEmpty();

    }
}