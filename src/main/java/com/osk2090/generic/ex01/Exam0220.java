package com.osk2090.generic.ex01;

import java.util.Date;

class ObjectBox {
    Object value;

    public Object get() {
        return this.value;
    }

    public void set(Object value) {
        this.value = value;
    }
}
public class Exam0220 {
    public static void main(String[] args) {
        ObjectBox b1 = new ObjectBox();
        ObjectBox b2 = new ObjectBox();
        ObjectBox b3 = new ObjectBox();
        ObjectBox b4 = new ObjectBox();

        b1.set(new Member("홍길동", 20));
        b2.set("hello");
        b3.set(new Date());
        b4.set(100);
        //이렇게 ObjectBox에 다양한 타입의 값을 넣을 수 있는 이유는
        //set()의 파라미터 타입은 Object이기 때문이다
//        Object는 모든 자바 객체를 받을 수 있다

//        ObjectBox 객체에서 값 꺼내기
        //값을 꺼낼 때마다 형변환 해야한다
        Member v1 = (Member) b1.get();
        System.out.println(v1);

        String v2 = (String) b2.get();
        System.out.println(v2);

        Date v3 = (Date) b3.get();
        System.out.println(v3);

        int v4 = (int) b4.get();
        System.out.println(v4);

//        ObjectBox의 이점
        /*
        이전 방식에 비해 객체의 타입 별로 Box 클래스를 구분해서 쓰지 않으니 코딩이 편하다
        이렇게 ObjectBox 클래스의 인스턴스 변수를 Object로 선언하니
        다양한 객체를 보관할 수 있다

        ObjectBox의 단점
        MemberBox나 StringBox,IntegerBox 처럼 특정 타입의 객체 제한할 수 없다
        또한 값을 꺼낼 때 원래의 타입으로 바꾸기 위해 형변환 해야 하는 불편함이 있다
        그렇다고 이전처럼 각 카입별로 Box클래스를 정의하는 것은 바람직하지 않다

        이런 문제점을 해결하기 위해 나온 문법이 제네릭이다
        제네릭 문법을 이용하면 한개의 클래스가 다양한 타입의 객체를 제한적으로 다룰 수 있다
        즉 각 타입 별로 클래스를 정의해야 하는 것을 한 개의 클래스로 만들 수 있다
         */
    }
}