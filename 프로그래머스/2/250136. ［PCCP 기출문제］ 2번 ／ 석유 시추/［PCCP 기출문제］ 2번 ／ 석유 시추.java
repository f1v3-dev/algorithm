import java.util.*;

class Solution {

    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {1, -1, 0, 0};
    private int n;
    private int m;
    private int[] oilColumn;

    public int solution(int[][] land) {


        n = land.length;
        m = land[0].length;
        oilColumn = new int[m];

        boolean[][] visited = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, visited, i, j);
                }
            }
        }

        return Arrays.stream(oilColumn)
                .max()
                .getAsInt();
    }

    private void bfs(int[][] land, boolean[][] visited, int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        visited[x][y] = true;

        int count = 1;
        Set<Integer> columnSet = new HashSet<>();
        while (!queue.isEmpty()) {

            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            columnSet.add(cy);

            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny] || land[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                count += 1;
            }
        }

        for (Integer index : columnSet) {
            oilColumn[index] += count;
        }
    }
}