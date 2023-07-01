import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);

            String[] input = br.readLine().split(" ");
            Queue<int[]> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(input[i]);
                queue.offer(new int[] { i, priority });
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int [] frontValue = queue.poll();
                boolean isMaxPriority = true;

                for (int[] val : queue) {
                    if (val[1] > frontValue[1]) {
                        queue.offer(frontValue);
                        isMaxPriority = false;
                        break;
                    }
                }

                if (isMaxPriority) {
                    count++;
                    if (frontValue[0] == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
        br.close();

    }
}