import java.util.Scanner;

public class Main {

    public static long C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        C = sc.nextLong();

        System.out.print(pow(A, B));
    }

    /**
     * @param A : 밑
     * @param exponent : 지수
     */
    private static long pow(long A, long exponent) {

        if (exponent == 1) {
            return A % C;
        }

        /**
         * 원리 : 10^11 = 10^5 * 10^5 * 10
         * 10^5 = 10^2 * 10^2 * 10
         * 10^2 = 10 * 10
         */
        long temp = pow(A, exponent / 2);

        // 홀수인 경우 밑을 한 번 더 곱해줌
        if (exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }

        return temp * temp % C;
    }


}