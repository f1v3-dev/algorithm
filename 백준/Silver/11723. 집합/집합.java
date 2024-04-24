import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr = new int[21];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String operation = input[0];
            int num = 0;
            if (!("all".equals(operation) || "empty".equals(operation))) {
                num = Integer.parseInt(input[1]);
            }

            func(operation, num);
        }

        System.out.println(sb);
    }

    private static void func(String op, int num) {
        switch (op) {
            case "add":
                if (arr[num] == 0) arr[num] = 1;
                break;
            case "remove":
                if (arr[num] == 1) arr[num] = 0;
                break;
            case "check":
                if (arr[num] == 0) sb.append(0).append("\n");
                if (arr[num] == 1) sb.append(1).append("\n");
                break;
            case "toggle":
                if (arr[num] == 1) {
                    arr[num] = 0;
                } else {
                    arr[num] = 1;
                }
                break;
            case "all":
                for (int i = 1; i <= 20; i++) {
                    arr[i] = 1;
                }
                break;
            case "empty":
                for (int i = 1; i <= 20; i++) {
                    arr[i] = 0;
                }
                break;
        }
    }
}