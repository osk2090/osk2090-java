package com.osk2090.io.ex02;

import java.io.FileOutputStream;

public class Exam0110 {
    public static void main(String[] args) throws Exception {
        /*
        파일로 데이터를 출력하는 객체를 준비한다
        new FileOutputStream(파일경로)
        지정된 경오레 해당 파일을 자동으로 생성한다
        기존에 같은 이름의 파일이 있으면 덮어쓴다
        주의!기존 파일이 삭제된다
        파일 경로가 절대 경로가 아니면
        리눅스,유닉스:/로 시작하지 않으면
        윈도우:c:\등으로 시작하지 않으면
        현재 디렉토리가 기준이 된다
        */
        FileOutputStream out = new FileOutputStream("temp/test1.data");

        /*
        1바이트를 출력한다
        write(int):1바이트를 출력하는 메서드이다
        파라미터의 타입이 int라고 해서 4바이트만 출력하는 것이 아니다
        오직 1바이트만 출력한다
         */
        out.write(0x7a6b5c4d);
        out.write(2);
        out.write(40);
        out.write(100);
        out.write(101);
        out.write(102);
        out.write(127);
        out.write(255);
        out.write('A');
        out.write('가');

        /*
        출력 도구를 닫는다
        os에서 관리하는 자원 중에서 한정된 개수를 갖는 자원에 대해
        여러 프로그램이 공유하는 경우 항상 사용 후 os에 반납해야 한다
        그래야 다른 프로그램이 해당 자원을 사용할 수 있다
        이런 자원을 사용하는 클래스는 자원을 재헤시키는 close()라는 메서드가 있다
        보통 java.lang.AutoCloseable 인터페이스를 구현하고 있다
        해당 메서드를 호출하면
        FileOutputStream이 작업하는 동안 사용했던 버퍼(임시메모리)를 비운다
        OS에서 제공한 파일과의 연결을 끊는다
         */

        out.close();
// 파일 입출력 API 주요 클래스 (java.io 패키지)
// 1) 데이터 읽기
// InputStream (추상 클래스)
//   +-- FileInputStream : 바이트 단위로 읽기 (binary stream)
//
// Reader (추상 클래스)
//   +-- FileReader : 문자 단위로 읽기 (character stream)
//
// 2) 데이터 쓰기
// OutputStream (추상 클래스)
//   +-- FileOutputStream : 바이트 단위로 쓰기 (binary stream)
//
// Writer (추상 클래스)
//   +-- FileWriter : 문자 단위로 쓰기 (character stream)

// ## 바이너리 파일 vs 텍스트 파일
// 1) 바이너리 파일
// - character set(문자표) 규칙에 따라 작성한 파일이 아닌 파일.
// - 기본 텍스트 편집기(메모장, vi 에디터 등)로 편집할 수 없는 파일을 말한다.
// - 만약 텍스트 편집기로 변경한 후 저장하면, 파일 포맷이 깨지기 때문에 무효한 파일이 된다.
// - 예) .pdf, .ppt, .xls, .gif, .mp3, .jpg, .hwp, .mov, .avi, .exe, .lib 등
// - 바이너리 파일을 편집하려면 해당 파일 포맷을 이해하는 전용 프로그램이 필요하다.
//
// 2) 텍스트 파일
// - 특정 character set(문자표) 규칙에 따라 작성한 파일.
// - 기본 텍스트 편집기(메모장, vi 에디터 등)로 편집할 수 있는 파일을 말한다.
// - 예) .txt, .csv, .html, .js, .css, .xml, .bat, .c, .py, .php, .docx, .pptx, .xlsx 등
// - 텍스트 파일은 전용 에디터가 필요 없다.
// - 텍스트를 편집할 수 있는 에디터라면 편집 후 저장해도 유효하다.

// 바이너리 데이터 읽고, 쓰기
// - 읽고 쓸 때 중간에서 변환하는 것 없이 바이트 단위로 그대로 읽고 써야 한다.
// - InputStream/OutputStream 계열의 클래스를 사용하라.
//
// 텍스트 데이터 읽고, 쓰기
// - 읽고 쓸 때 중간에서 문자 코드표에 따라 변환하는 것이 필요하다.
// - Reader/Writer 계열의 클래스를 사용하라.
    }
}