package com.osk2090.generic.ex01;

import java.util.ArrayList;

public class ref {
    public static void main(String[] args) {
        ArrayList<Member> list = new ArrayList<>();
        list.add(new Member("오은석", 29));
        list.add(new Member("이중섭", 41));
        list.add(new Member("이순신", 44));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        ArrayList<?> list1;//해당 List를 타입상관없이 다루고 싶다면 <?>로 선언하면!
        list1 = new ArrayList<>();
        list1 = new ArrayList<Object>();//슈퍼 클래스도 넣을 수 있고
        list1 = new ArrayList<String>();//서브 클래스들도 넣을 수 있다
        list1 = new ArrayList<Integer>();
        list1 = new ArrayList<Member>();

        //단 이경우에는 제네릭의 타입이 명확하게 선언되지 않았기 때문에 제네릭 검사가 필요한 코드를 컴파일 불가하다
//        list1.add(new String("오은석"));//컴파일 불가
    }
}