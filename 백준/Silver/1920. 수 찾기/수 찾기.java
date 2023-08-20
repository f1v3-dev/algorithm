import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input1 = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input1[i]);
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int result = binarySearch(arr, Integer.parseInt(input2[i]));
            if (result >= 0) {
                System.out.println(1);
            } else System.out.println(0);
        }

    }
}