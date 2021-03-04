package com.osk2090.basic.ex07;

import java.util.HashSet;

public class Exam0310 {
    static class Member {
        String name;
        int age;

        public Member(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Member m1 = new Member("오", 10);
        Member m2 = new Member("은", 20);
        Member m3 = new Member("석", 30);
        Member m4 = new Member("옹", 40);

        Member m5 = new Member("오", 10);

        HashSet<Member> set = new HashSet<>();
        set.add(m1);
        set.add(m2);
        set.add(m3);
        set.add(m4);

        set.add(m5);//m1과 같은 값을 저장한다
        /*
        하지만 출력해보면 저장되는것을 확인할수 있다
        그 이유는 기본적인 hashCode()와 equals()의 리턴값으로 판단하는데
        여기서 오버라이딩을 하지 않았기에 필터링을 하지 못한 것이다.
        Object의 hashCode()는 인스턴스가 다르면 무조건 다른 해시값을 리턴한다
        Object의 equals()는 인스턴스의 주소가 같은지 검사한다
        그래서 m1과 m5가 같은 데이터인데도 인스턴스가 다르기 때문에 같은 값으로 간주하지 않는것이다.
         */
        System.out.println(set);
    }
}