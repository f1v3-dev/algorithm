import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int section = 0;
    static int n;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        solve(maxHeight);
        System.out.println(section);
    }

    private static void solve(int maxHeight) {

        for (int height = 0; height < maxHeight; height++) {
            int count = 0;
            boolean[][] visited = new boolean[n][n];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] > height && !visited[x][y]) {
                        bfs(x, y, height, visited);
                        count++;
                    }
                }
            }

            section = Math.max(section, count);
        }
    }


    private static void bfs(int x, int y, int height, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (map[nx][ny] > height && !visited[nx][ny]) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

    }
}