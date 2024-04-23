import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int m;
    static int[][] graph;
    static boolean[] visited;
    static int start;
    static int end;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);

        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        dfs(start, 0);

        System.out.println(result);
    }

    private static void dfs(int start, int count) {
        visited[start] = true;

        if (start == end) {
            result = count;
            return;
        }

        for (int i = 0; i <= n; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(i, count + 1);
            }
        }
    }

}