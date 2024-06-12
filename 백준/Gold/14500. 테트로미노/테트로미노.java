import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] paper;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        visited = new boolean[n][m];

        // 종이 초기화
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(max);
    }

    private static void solve() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
                calculate(i, j);
            }
        }

    }

    private static void dfs(int x, int y, int depth, int sum) {

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }

            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + paper[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }


    private static void calculate(int x, int y) {

        // ㅜ 모양 : 4가지 경우의 수가 존재

        // 1. 기본 모양
        if (x + 1 < n && y + 2 < m) {
            int sum = paper[x][y] + paper[x][y + 1] + paper[x][y + 2] + paper[x + 1][y + 1];
            max = Math.max(max, sum);
        }

        // 2. 90도 회전
        if (x + 2 < n && y + 1 < m) {
            int sum = paper[x + 1][y] + paper[x][y + 1] + paper[x + 1][y + 1] + paper[x + 2][y + 1];
            max = Math.max(max, sum);
        }

        // 3. 180도 회전 (대칭)
        if (x + 1 < n && y + 2 < m) {
            int sum = paper[x][y + 1] + paper[x + 1][y] + paper[x + 1][y + 1] + paper[x + 1][y + 2];
            max = Math.max(max, sum);
        }

        // 4. 270도 회전
        if (x + 2 < n && y + 1 < m) {
            int sum = paper[x][y] + paper[x + 1][y] + paper[x + 1][y + 1] + paper[x + 2][y];
            max = Math.max(max, sum);
        }
    }
}