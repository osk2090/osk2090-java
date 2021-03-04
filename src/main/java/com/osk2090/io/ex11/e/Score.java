package com.osk2090.io.ex11.e;

public class Score implements java.io.Serializable {
    private static final long sertialVersionUID = 1L;

    //인스턴스 변수의 구분
    //name kor eng math는 사용자가 입력한 값을 저장하는 변수이다

    String name;
    int kor;
    int math;
    int eng;

    /*
    sum aver는 위의 변수를 계산해서 그 결과를 저장하는 변수이다
    이렇게 다른 인스턴스 변수의 값을 가지고 계산한 결롸를 저장하는 변수인 경우
    serialize 대상에서 제외해야한다
    왜
    값의 왜곡을 막기 위함이다

    그럼 sum과 aver는 어떻게 처리해야 하는가
    serialize 데이터를 읽는 쪽에서 데이터를 다 읽은 후 계산을 수행해서 값을 처리해야 한다
    그래야만 데이터 왜곡을 막을 수 있다

    데이터 왜곡
    kor eng math에 저장된 값과 sum과 aver에 저장된 값이 일치하지 않는 경우를 말한다
    이런 변수는 serialize대상에서 제외해야 하는다
    그 명령어가 tranient(일시적인)이다
    transient는 변수의 성질을 변경(modifier)한다
    즉 serialize되지 않도록 변경한다
     */
    transient int sum;
    transient double aver;

    public Score() {
        System.out.println("Score() 생성자 호출");
    }

    public void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }

    @Override
    public String toString() {
        return "Score{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", math=" + math +
                ", eng=" + eng +
                ", sum=" + sum +
                ", aver=" + aver +
                '}';
    }
}