package com.osk2090.basic.ex07;

import java.util.HashSet;
import java.util.Objects;

public class Exam0340 {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Member member = (Member) o;
            return age == member.age && Objects.equals(name, member.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
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

        set.add(m5);//m1과 같은 값을 저장하지만 equals()과 hashCode() 오버라이딩을 하였기에 필터링되어 저장되지 않는다

        System.out.println(set);
    }
}