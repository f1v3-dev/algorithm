import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // 지도 초기화
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 방문 배열 초기화
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }

        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int px = p[0];
            int py = p[1];

            // 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int tempX = px + dx[i];
                int tempY = py + dy[i];

                if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < M) {
                    if (!visited[tempX][tempY] && map[tempX][tempY] == 1) {
                        queue.offer(new int[]{tempX, tempY});

                        // 계속해서 값을 증가시키기
                        map[tempX][tempY] = map[px][py] + 1;
                        visited[tempX][tempY] = true;
                    }
                }
            }
        }
    }
}