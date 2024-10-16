import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs(map, 0, 0);
    }

    private static void bfs(int[][] map, int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[map.length][map.length];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int move = map[cx][cy];

            for (int i = 0; i < 2; i++) {
                int nx = cx + (dx[i] * move);
                int ny = cy + (dy[i] * move);

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map.length && !visited[nx][ny]) {

                    if (nx == map.length - 1 && ny == map.length - 1) {
                        System.out.println("HaruHaru");
                        return;
                    }

                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println("Hing");
    }
}