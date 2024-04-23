import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        // graph 초기화
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(K);

        sb.append("\n");
        // BFS
        visited = new boolean[N + 1];
        bfs(K);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;

        sb.append(start + " ");

        // 시작점을 기준으로 dfs 진행
        for (int i = 0; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        // 시작점을 기준으로 bfs 진행
        while (!queue.isEmpty()) {
            start = queue.poll();
            sb.append(start + " ");

            for (int i = 0; i <= N; i++) {
                if (graph[start][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}