import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        visited = new boolean[N + 1];
        count = 0;
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int start) {

        visited[start] = true;
        for (int i = 0; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
    }
}