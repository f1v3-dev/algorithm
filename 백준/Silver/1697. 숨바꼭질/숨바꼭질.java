import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int N;
    private static int K;
    private static int[] map = new int[100001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);
        map[N] = 1;

        while (!queue.isEmpty()) {
            int nowPoint = queue.poll();

            /**
             * [N + 1], [N - 1], [2 * N]
             * 3가지 작업 진행
             */
            for (int i = 0; i < 3; i++) {
                int nextPoint;

                if (i == 0) {
                    nextPoint = nowPoint + 1;
                } else if (i == 1) {
                    nextPoint = nowPoint - 1;
                } else {
                    nextPoint = 2 * nowPoint;
                }

                if (nextPoint == K) {
                    System.out.println(map[nowPoint]);
                    return;
                }

                // 범위 내부 && 값이 없는 경우
                if ((nextPoint > 0 && nextPoint <= 100000) && (map[nextPoint] == 0)) {
                    queue.offer(nextPoint);
                    map[nextPoint] = map[nowPoint] + 1;
                }
            }
        }
    }
}