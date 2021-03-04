package com.osk2090.io.ex11.b;

public class Exam0232 {
    static class Score implements Cloneable {
        //Cloneable 인터페이스에는 메서드가 없다
        //따라서 이 인터페이스를 구현하는 클래스는 메서드를 정의할 필요가 없다
        //이 인터페이스 목적은 복제 가능 여부를 설정하는 용도이다
        String name;

        @Override
        protected Score clone() throws CloneNotSupportedException {
            return (Score) super.clone();
        }
    }

    public static void main(String[] args) throws Exception {
        Score obj = new Score();
        obj.name = "오은석";
        System.out.println(obj instanceof Cloneable);

        Score copy = obj.clone();
        System.out.println(obj == copy);//복제를 허락했기 때문에 false가 나온다
        System.out.println(obj.name);
        System.out.println(copy.name);

    }
}