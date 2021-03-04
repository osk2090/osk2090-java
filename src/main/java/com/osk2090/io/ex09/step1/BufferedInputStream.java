package com.osk2090.io.ex09.step1;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {
    InputStream 연결부품;

    byte[] buf = new byte[8196];//배열 준비
    int size;//배열에 저장되어 있는 바이트의 수
    int cursor;//바이트 읽은 배열의 위치

    public BufferedInputStream(InputStream in) {
        연결부품 = in;//이 객체와 연결될 부품을 파라미터로 받는다
    }

    @Override
    public int read() throws IOException {
        if (cursor == size) {
            if ((size = 연결부품.read(buf)) == -1) {
                return -1;
            }
            cursor = 0;
        }
        return buf[cursor++] & 0x000000ff;//첫비트가 1이면 음수로 간주하여 앞의 24bit를 1로 채운다
    }
}