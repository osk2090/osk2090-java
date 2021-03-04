package com.osk2090.generic.ex01;

import java.util.Calendar;
import java.util.Date;

public class Exam0110 {
    public static Object echo(Object obj) {
        return obj;
    }

    public static void main(String[] args) {
        //echo() 리턴 타입이 Object이기 때문에 String 레퍼런스로 바로 받을 수 없다
        //해결책은 형변환이다

        //String obj1 = echo(new String("hello));컴파일 오류
        String obj2 = (String) echo(new String("hello"));

        //잘못된 형변환은 컴파일러는 속일 수 있을 지라도,runtime에서는 오류를 발생시킨다
//        Integer obj3 = (Integer) echo(new String ("hello"));//실행오류
        Date obj4 = (Date) echo(new Date());

        Calendar obj5 = (Calendar) echo(Calendar.getInstance());
    }
}