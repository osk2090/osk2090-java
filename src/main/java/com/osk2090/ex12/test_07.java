package com.osk2090.ex12;

import java.util.ArrayList;
import java.util.function.Consumer;

public class test_07 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("브루스웨인");
        names.add("조커");
        names.add("제임스고든");
        names.add("하비덴트");
        names.add("알프레드");

        //forEach() 사용 전
//        for (String name : names) {
//            System.out.println(name);
//        }

        //forEach() 사용 후
        class MyConsumer<T> implements Consumer<T> {
            @Override
            public void accept(T t) {
                System.out.println(t);
            }
        }
        names.forEach(new MyConsumer<String>());
    }
}