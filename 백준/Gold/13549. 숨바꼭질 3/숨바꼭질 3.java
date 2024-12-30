import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        bfs(n, k);

    }

    private static void bfs(int start, int end) {
        int[] result = new int[100001];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == end) {
                break;
            }

            // 2 * X
            if (2 * cur <= 100_000 && result[2 * cur] > result[cur]) {
                result[2 * cur] = result[cur];
                queue.offer(2 * cur);
            }

            // X - 1
            if (cur - 1 >= 0 && result[cur - 1] > result[cur] + 1) {
                result[cur - 1] = result[cur] + 1;
                queue.offer(cur - 1);
            }

            // X + 1
            if (cur + 1 <= 100_000 && result[cur + 1] > result[cur] + 1) {
                result[cur + 1] = result[cur] + 1;
                queue.offer(cur + 1);
            }
        }

        System.out.println(result[end]);
    }

}