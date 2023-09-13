package com.nhnacademy;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), ", ");

        int result = solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        System.out.println(result);
    }

    // solution
    public static int solution(int first, int second) {
        int gcdVal = gcd(first, second);

        return (first * second) / gcdVal;
    }

    public static int gcd(int firstNum, int secondNum) {
        if (firstNum % secondNum == 0) {
            return secondNum;
        }
        return gcd(secondNum, firstNum % secondNum);
    }

}