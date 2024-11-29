import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        모든 요청이 배정될 수 있는 경우 요청한 금액을 그대로 배정
        그렇지 못한 경우 특정한 정수 상한액을 계산 -> 그 이상인 예산 요청에는 모두 상한액을 배정
        -> 상한액 이하 예산요청은 요청한 금액 그대로 배정
         */

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = arr[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.min(arr[i], mid);
            }

            if (sum <= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}