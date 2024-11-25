class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        // A의 GCD를 구한다.
        int gcdA = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
        }

        int gcdB = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            gcdB = gcd(gcdB, arrayB[i]);
        }

        int answer = 0;
        // gcdA로 arrayB를 나눠본다.
        boolean isPossible = true;
        for (int b : arrayB) {
            if (b % gcdA == 0) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            answer = gcdA;
        }

        isPossible = true;
        for (int a : arrayA) {
            if (a % gcdB == 0) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            answer = Math.max(answer, gcdB);
        }

        return answer;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}