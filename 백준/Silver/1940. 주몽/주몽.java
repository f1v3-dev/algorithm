import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        int count = 0;

        while (start < end) {

            int sum = arr[start] + arr[end];

            if (sum == M) {
                count++;
                start++;
                continue;
            }

            if (sum < M) {
                start++;
            } else if (sum > M) {
                end--;
            }
        }

        System.out.println(count);
    }
}