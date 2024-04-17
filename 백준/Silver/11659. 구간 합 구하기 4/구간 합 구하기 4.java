import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] origin = new int[N];
        int[] arr = new int[N + 1];

        for (int i = 0; i < origin.length; i++) {
            origin[i] = Integer.parseInt(input[i]);
        }

        sumArray(origin, arr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            int result = arr[end] - arr[start - 1];
            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }

    private static void sumArray(int[] origin, int[] arr) {
        arr[0] = 0;
        arr[1] = origin[0];

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + origin[i - 1];
        }
    }
}