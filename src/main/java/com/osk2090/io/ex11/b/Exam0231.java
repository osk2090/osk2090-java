package com.osk2090.io.ex11.b;

public class Exam0231 {
    static class Score {
        String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return (Score) super.clone();
        }
    }

    public static void main(String[] args) {
        Score obj = new Score();
        System.out.println(obj instanceof Cloneable);
//        Score copy = obj.clone();//런타임 오류
/*
Object에서 상속받은 clone()을 호출하려면
해당 클래스에 대해 복제 기능을 활설화해야 한다
방법은 java,lang,Cloneable 인터페이스를 구현해야한다
 */
    }
}