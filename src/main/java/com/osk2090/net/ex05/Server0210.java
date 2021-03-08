package com.osk2090.net.ex05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/*
비연결
연결없이 데이터를 송수신한다
상대편이 네트워크에 연결되어 있지 않다면 그 데이터는 버려진다
그래서 전송 여부를 신뢰할 수 없다
실생활에서 편지와 같다
 */
public class Server0210 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("서버 실행 중...");

        System.out.println("소켓 생성 전 잠깐!>");
        scanner.nextLine();

        //데이터 송수신을 담당할 소켓을 먼저 준비한다
        //보내는 쪽이나 받는 쪽이나 같은 소켓 클래스를 사용한다
        //서버 소켓이 따로 없다
        //받는 쪽에서는 소켓을 생성할 때 포트 번호를 설정한다
        DatagramSocket socket = new DatagramSocket(8888);

        //받은 데이터를 저장할 버퍼 준비
        byte[] buf = new byte[8196];

        //빈 패킷 준비
        DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);

        System.out.println("데이터를 읽기 전에 잠깐 멈춤>");
        scanner.nextLine();

        //빈 패킷을 사용하여 클라이언트가 보낸 데이터를 받는다
        //데이터를 받을 때까지 리턴하지 않는다
        socket.receive(emptyPacket);
        System.out.println("데이터를 받았음!");

        socket.close();
        scanner.close();

        //빈 패킷에 저장된 클라이언트가 보낸 데이터를 꺼낸다
        //패킷에 저장된 UTF-8로 인코딩된 바이트 배열을 가지고 String 객체(UTF-16)를 만든다
        String message = new String(
                emptyPacket.getData(),
                0,
                emptyPacket.getLength(),
                "UTF-8"
        );
        System.out.println(message);
    }
}