package com.osk2090.generic.ex04;

import java.lang.reflect.Array;

public class Exam0110 {
    //제네릭의 타입을 지정할 때 수퍼클래스를 지정하지 않으면 모든 타입이 가능하다
    //즉 T 자리에 어떤 타입이라도 올 수 있다

    static class ArrayList<T> {
        T[] arr;//T 타입의 배열을 만들 준비
        int index = 0;

        @SuppressWarnings("unchecked")
        public ArrayList(Class<T> clazz) {
            //제네릭 타입 파라미터로 레퍼런스는 선언할 수 있지만 인스턴스를 생성할 수는 없다
            //this.arr = new T[0];//컴파일 오류

            //다음과 같이 Array.newInstance()로 배열을 생성해야 한다.
            this.arr = (T[]) Array.newInstance(clazz, 10);//clazz 타입의 베열의 10칸으로 새로 만든다
        }

        public void add(T v) {//T 타입의 v 데이터를 추가
            arr[index++] = v;
        }

        public T get(int index) {//해당 인덱스의 데이터를 출력
            return arr[index];
        }

        public static void main(String[] args) {
            ArrayList<Member> obj = new ArrayList<>(Member.class);//Member class를 삽입
            obj.add(new Member());//모든 클래스는 Member클래스의 서브 클래스이므로 상속의 다형성이 가능하다
            obj.add(new Student());
            obj.add(new Teacher());
            obj.add(new Manager());
            obj.add(new Administrator());

            System.out.println(obj.get(0));
            System.out.println(obj.get(1));
            System.out.println(obj.get(2));
            System.out.println(obj.get(3));
            System.out.println(obj.get(4));

            //제네릭의 타입의 수퍼 클래스를 지정하지 않았기 때문에 어떤타입이라도 가능하다
            ArrayList<Manager> obj2 = new ArrayList<>(Manager.class);
            ArrayList<Teacher> obj3 = new ArrayList<>(Teacher.class);
            ArrayList<Student> obj4 = new ArrayList<>(Student.class);
            ArrayList<Administrator> obj5 = new ArrayList<>(Administrator.class);
            ArrayList<Manager> obj6 = new ArrayList<>(Manager.class);
            ArrayList<String> obj7 = new ArrayList<>(String.class);

            System.out.println(obj2);
            System.out.println(obj3);
            System.out.println(obj4);
            System.out.println(obj5);
            System.out.println(obj6);
            System.out.println(obj7);
        }
    }
}