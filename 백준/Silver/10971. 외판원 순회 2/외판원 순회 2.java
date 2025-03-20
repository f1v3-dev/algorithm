import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(input[j]);
            }
        }

        solve(n, w);

        System.out.println(minCost);
    }

    private static void solve(int n, int[][] w) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, 0, 1, visited, w, n);
    }

    private static void dfs(int current, int cost, int depth, boolean[] visited, int[][] w, int n) {
        if (depth == n) {

            if (w[current][0] > 0) {
                minCost = Math.min(cost + w[current][0], minCost);
            }
            return;
        }

        for (int next = 0; next < n; next++) {
            if (!visited[next] && w[current][next] > 0) {
                visited[next] = true;
                dfs(next, cost + w[current][next], depth + 1, visited, w, n);
                visited[next] = false;
            }
        }
    }
}