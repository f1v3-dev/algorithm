import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] map;
    static int num;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        map = new char[num][num];

        for (int i = 0; i < num; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int normal = 0;
        int abnormal = 0;

        // 정상인 경우
        boolean[][] visited = new boolean[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, visited);
                    normal++;
                }
            }
        }

        // 적록색약인 경우 (G -> R로 변경)
        for (int i = 0; i < num; i++) {
            map[i] = new String(map[i]).replaceAll("G", "R").toCharArray();
        }

        visited = new boolean[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, visited);
                    abnormal++;
                }
            }
        }

        System.out.println(normal + " " + abnormal);
    }

    private static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= num || ny < 0 || ny >= num) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] == map[cx][cy]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}