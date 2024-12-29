import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());

            int[][] board = new int[l][l];

            // start
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);


            // end
            input = br.readLine().split(" ");
            int ex = Integer.parseInt(input[0]);
            int ey = Integer.parseInt(input[1]);

            bfs(board, x, y, ex, ey);
        }
    }

    private static void bfs(int[][] board, int x, int y, int ex, int ey) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];

            if (cx == ex && cy == ey) {
                System.out.println(cnt);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.add(new int[]{nx, ny, cnt + 1});
                }
            }
        }
    }

}