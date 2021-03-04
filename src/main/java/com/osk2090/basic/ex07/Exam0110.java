package com.osk2090.basic.ex07;

import java.util.HashSet;

public class Exam0110 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // Set에 값 추가하기
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        System.out.println(set);

        // Set은 집합의 특성을 따른다.
        // 같은 값을 중복해서 넣을 수 없다.
        set.add("aaa");
        set.add("bbb");
        System.out.println(set);

        // null을 넣을 수 있다. 단 중복해서 넣을 수 없다.
        set.add(null);
        set.add(null);

        System.out.println(set);
        //출력하면 입력한 순서대로가 아닌 이유는
//        저장할 때 각 인스턴스의 hashCode() 리턴 값으로 위치를 정하기 때문이다.
    }
}