import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * S층에서 G층으로 가기 위해 눌러야 하는 버튼 수의 최소값
 */
public class Main {

    static int F; // 총 층수
    static int S; // 현재 있는 층
    static int G; // 도착해야되는 층
    static int U; // 위로 올라가는 버튼
    static int D; // 아래로 내려가는 버튼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);

        bfs();
    }

    private static void bfs() {
        boolean[] visited = new boolean[F + 1];
        int[] dist = new int[F + 1];
        dist[S] = 1;
        visited[S] = true;

        int dx[] = {U, -D};

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int i = 0; i < 2; i++) {
                int x = current + dx[i];

                if (x > 0 && x <= F && !visited[x]) {
                    queue.offer(x);
                    dist[x] = dist[current] + 1;
                    visited[x] = true;
                }
            }

        }

        if (dist[G] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(dist[G] - 1);
        }
    }
}