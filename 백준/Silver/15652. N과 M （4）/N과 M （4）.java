import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n + 1];
        solve();

        System.out.println(sb);
    }

    private static void solve() {
        // 1. 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        // 2. 고른 수열은 오름차순이어야 한다.

        backtracking(0, 1);
    }

    private static void backtracking(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            backtracking(depth + 1, i);
        }
    }
}