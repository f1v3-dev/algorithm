import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int count = 0;
    private static int area = 0; // 넓이
    private static int k = 0;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] arr;
    private static boolean[][] visited;
    private static int n;
    private static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    dfs(i, j);
                    area = Math.max(area, k);
                    k = 0;
                }
            }
        }

        System.out.println(count);
        System.out.println(area);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        k++;

        // 상하좌우 확인
        for (int i = 0; i < 4; i++) {
            int tempX = x + dx[i];
            int tempY = y + dy[i];

            // 범위 벗어나는 경우 방지
            if (tempX >= 0 && tempY >= 0 && tempX < n && tempY < m) {
                if (!visited[tempX][tempY] && arr[tempX][tempY] == 1) {
                    dfs(tempX, tempY);
                }
            }
        }
    }
}