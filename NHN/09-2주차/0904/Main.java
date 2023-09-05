package com.nhnacademy.algorithm;

public class Main {

    public static String solution(String input) {

        // ASCII : A-Z 65-90, a-z 97-122
        // 대문자 -> 소문자 : +32
        // 소문자 -> 대문자 : -32
        // 특수문자는 그대로 출력

        StringBuilder sb = new StringBuilder();
        char[] tokens = input.toCharArray();
        for (char token : tokens) {
            if (65 <= token && token <= 90) {
                sb.append((char)(token + 32));
            }
            else if (97 <= token && token <= 122) {
                sb.append((char)(token - 32));
            }
            else {
                sb.append(token);
            }
        }

        return sb.toString();
    }
}