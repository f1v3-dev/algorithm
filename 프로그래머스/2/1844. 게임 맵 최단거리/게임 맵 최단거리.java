import java.util.*;

class Solution {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        return bfs(maps, 0, 0);
    }

    private int bfs(int[][] maps, int x, int y) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});

        boolean[][] visited = new boolean[n][m];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int count = cur[2] + 1;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {

                        if (nx == n - 1 && ny == m - 1) {
                            return count + 1;
                        }
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, count});
                    }
                }
            }
        }

        return -1;
    }
}