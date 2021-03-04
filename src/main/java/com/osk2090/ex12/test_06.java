package com.osk2090.ex12;

public class test_06 {

    static class Message {
        String name;
        int age;

        public Message() {
            this.name = "이름없음";
        }

        public Message(String name) {
            this.name = name;
        }

        public Message(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public static void print(Message message) {
            if (message.name.equals("이름없음")) {
                System.out.println("이름없음");
            } else {
                System.out.printf("%s님 반갑습니다.\n", message.name);
            }
        }
    }

    static interface Factory1 {
        Message get();
    }

    static interface Factory2 {
        Message get(String name);
    }

    static interface Factory3 {
        Message get(String name, int age);
    }

    public static void main(String[] args) {
        Factory1 f1 = Message::new;//public Message() 생성자
        Message.print(f1.get());

        Factory2 f2 = Message::new;//public Message(String name) 생성자
        Message.print(f2.get("고든 프리맨"));

        Factory3 f3 = Message::new;//public Message(String name, int age) 생성자
        Message.print(f3.get("G맨", 100));
    }
}