import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
         *
         * X가 3으로 나누어 떨어지면, 3으로 나눈다.
         * X가 2로 나누어 떨어지면, 2로 나눈다.
         * 1을 뺀다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());


        int[] dp = new int[number + 1];
        dp[1] = 0;

        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i - 1] + 1;
            
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[number]);
    }
}