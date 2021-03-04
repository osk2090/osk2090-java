package com.osk2090.Exception;

public class Exam0420 {
    static int sum;
    static float aver;

    static void computeScore(int kor, int eng, int math)
        throws Exception{
            if (kor < 0 || kor > 100 || eng < 0 || eng > 100 ||
                    math < 0 || math > 100) {
                try {
                    throw new Exception("입력 점수가 옳지 앖습니다.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sum = kor + eng + math;
            aver = sum / 3f;

        }

    public static void main(String[] args) {
        try {
            computeScore(100, 90, 80);
            System.out.printf("합계 %d\n 평균=%f\n", sum, aver);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }
}