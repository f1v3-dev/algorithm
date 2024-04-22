import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int M;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            // 배추 밭 맵 초기화
            visited = new boolean[N][M];
            map = new int[N][M];
            initMap(K);

            // bfs 진행하면서 count
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (!visited[j][k] && map[j][k] == 1) {
                        bfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int x, int y) {

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int xx = pair.getX();
            int yy = pair.getY();
            visited[xx][yy] = true;

            for (int i = 0; i < 4; i++) {
                int nx = xx + dx[i];
                int ny = yy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static void initMap(int k) throws IOException {

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            map[y][x] = 1;
        }
    }
}
