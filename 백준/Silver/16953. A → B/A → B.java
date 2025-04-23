import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        dfs(b, a, 1);
    }

    private static void dfs(int current, int target, int count) {
        if (current == target) {
            System.out.println(count);
            return;
        }

        if (current < target) {
            System.out.println(-1);
            return;
        }

        if (current % 2 == 0) {
            dfs(current / 2, target, count + 1);
        } else if (endWithOne(current)) {
            dfs(current / 10, target, count + 1);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean endWithOne(int value) {
        String str = String.valueOf(value);
        return str.charAt(str.length() - 1) == '1';
    }
}