package com.nhnacademy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));
    }

    public static int solution(int[] input) {
        int max = 0;

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                max = Math.max(max, gcd(input[i], input[j]));
            }
        }
        return max;
    }

    public static int gcd(int firstNum, int secondNum) {
        if (firstNum % secondNum == 0) {
            return secondNum;
        }
        return gcd(secondNum, firstNum % secondNum);
    }

}