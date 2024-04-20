import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int M; // 가로 칸의 수
    private static int N; // 세로 칸의 수
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        // map 초기화 & visited 초기화
        visited = new boolean[N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        /**
         * [반례]
         * 2 2
         * 0 0
         * 0 0
         * -> NPE 발생, (1이 존재하지 않음)
         * */
        try {
            bfs();
        } catch (NullPointerException e) {
            System.out.println(-1);
            return;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                max = Math.max(max, map[i][j]);
            }
        }

        // 시작할 때 익은 토마토를 기준으로 하기 때문에 -1일
        System.out.println(max - 1);
    }

    private static void bfs() {
        int[] p = queue.poll();
        int x = p[0];
        int y = p[1];

        visited[x][y] = true;

        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int xx = poll[0];
            int yy = poll[1];

            for (int i = 0; i < 4; i++) {
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < N && nowY < M) {
                    if (!visited[nowX][nowY] && map[nowX][nowY] == 0) {
                        map[nowX][nowY] = map[xx][yy] + 1;
                        visited[nowX][nowY] = true;
                        queue.offer(new int[]{nowX, nowY});
                    }
                }
            }
        }


    }
}