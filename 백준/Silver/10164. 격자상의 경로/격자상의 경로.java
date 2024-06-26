import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int k;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        solve();
    }

    private static void solve() {
        // n, m번 칸으로 이동
        // k번은 꼭 거쳐야 한다.
        int[][] dp = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        checkVisited();

        // 왼쪽 + 위쪽 = 현재 위치까지 갈 수 있는 경우의 수
        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1 || !visited[i][j]) {
                    continue;
                }
                if (i > 1) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (j > 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[n][m]);
    }

    private static void checkVisited() {

        // k의 위치 기준 왼쪽 위로, 오른쪽 아래로
        // visited = true로 처리해준다.

        // k == 0이면 모두 true
        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    visited[i][j] = true;
                }
            }
            return;
        }

        int kx = (k - 1) / m + 1;
        int ky = (k - 1) % m + 1;

        leftVisited(kx, ky);
        rightVisited(kx, ky);
    }

    private static void leftVisited(int x, int y) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                visited[i][j] = true;
            }
        }
    }

    private static void rightVisited(int x, int y) {
        for (int i = x; i <= n; i++) {
            for (int j = y; j <= m; j++) {
                visited[i][j] = true;
            }
        }
    }
}