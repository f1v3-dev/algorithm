import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        X일 동안 가장 많이 들어온 방문자 수 (0명 == SAD)
        최대 방문자 수가 0명이 아닌 경우, 기간이 몇 개 있는지 출력

        n: 블로그 시작한 일
        x: 방문자 파악을 원하는 기간
         */

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);

        int[] arr = new int[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }




        // 첫 슬라이딩 윈도우 진행
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += arr[i];
        }

        int max = sum;
        int count = 1;

        for (int i = x; i < n; i++) {
            sum = sum + arr[i] - arr[i - x];

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (max == 0) {
            sb.append("SAD");
        } else {
            sb.append(max).append("\n").append(count);
        }

        System.out.println(sb);
    }
}