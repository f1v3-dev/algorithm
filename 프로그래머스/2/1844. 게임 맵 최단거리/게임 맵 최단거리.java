import java.util.LinkedList;
import java.util.Queue;

class Position {
    int x;
    int y;
    int count;

    public Position(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;

        queue.offer(new Position(0, 0, 1));

        while (!queue.isEmpty()) {
            Position cur = queue.poll();
            int cx = cur.x;
            int cy = cur.y;
            int count = cur.count;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length
                        && !visited[nx][ny] && maps[nx][ny] == 1) {

                    // 도착지에 도달했을 경우 return
                    if (nx == maps.length - 1 && ny == maps[0].length - 1) {
                        return count + 1;
                    }

                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny, count + 1));
                }
            }
        }

        return -1;
    }
}