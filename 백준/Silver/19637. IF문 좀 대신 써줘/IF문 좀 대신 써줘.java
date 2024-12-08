import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        StringBuilder sb = new StringBuilder();

        String[] title = new String[n];
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            title[i] = input[0];
            score[i] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < m; i++) {
            int current = Integer.parseInt(br.readLine());

            int left = 0;
            int right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (score[mid] < current) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(title[left]).append("\n");
        }

        System.out.println(sb);
    }
}