package com.osk2090.io.ex11.e;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Exam0520 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileIn = new FileInputStream("temp/score.data");
        ObjectInputStream in = new ObjectInputStream(fileIn);

        Score score = (Score) in.readObject();
        in.close();
        System.out.println(score);//transient 값은 인스턴스를 준비한 후 별도의 메서드를 통해 다시 계산해야한다

        System.out.println("--------------");

        score.compute();//계산하는 메서드 호출
        System.out.println(score);//transient 값은 계산하는 메서드를 호출하여 값이 입력된다

        /*
        아니 그냥 sum aver 변수의 값을 파일에 저장한 후 읽으면 되지
        왜 이렇게 번거롭게 다시 계산하게 만드는가
        조금이라도 데이터 왜곡을 방지하기 위함이다
        그러니 번거롭다 생각말고 다른 인스턴스 변수의 값으로 계산한 결과는
        가능한 출력하지 말고 읽을 때 다시 계산하도록 한다
         */

    }
}