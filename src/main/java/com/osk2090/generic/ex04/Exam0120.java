package com.osk2090.generic.ex04;

import java.lang.reflect.Array;

public class Exam0120 {
    //제네릭의 타입을 지정할 때 수퍼 클래스를 지정하면 그 차입 및 서브 타입만 가능하다
    //다음 클래스의 타입 파라미터에는
    //Manager 나 그 하위 클래스만 지정할 수 있다
    static class ArrayList<T extends Manager> {
        T[] arr;
        int index;

        @SuppressWarnings("unchecked")
        public ArrayList(Class<T> clazz) {
            this.arr = (T[]) Array.newInstance(clazz, 10);
        }

        public void add(T v) {
            arr[index++] = v;
        }

        public T get(int index) {
            return arr[index];
        }
    }

    public static void main(String[] args) {
//        ArrayList<Member> obj = new ArrayList<Member>(Member.class);//컴파일 오류
//        ArrayList<Teacher> obj = new ArrayList<Teacher>(Teacher.class);//컴파일 오류
//        ArrayList<Student> obj = new ArrayList<Student>(Student.class);//컴파일 오류

        ArrayList<Manager> obj = new ArrayList<>(Manager.class);//자기자신은 가능하다
        ArrayList<Administrator> obj1 = new ArrayList<>(Administrator.class);//제네릭에 선언된 클래스의 서브클래스라서 가능하다

        obj.add(new Manager());
        obj.add(new Administrator());

        System.out.println(obj.get(0));
        System.out.println(obj.get(1));
    }
}