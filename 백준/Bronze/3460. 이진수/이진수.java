import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());

            // n -> 2진수로 변환
            while (n > 0) {
                sb.append(n % 2);
                n /= 2;
            }

            // 1의 위치 출력
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == '1') {
                    result.append(j).append(" ");
                }
            }
            System.out.println(result);
        }
    }
}