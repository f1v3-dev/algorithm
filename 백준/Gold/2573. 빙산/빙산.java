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

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int year = 0;
        int lump = 0; // 빙하 덩어리 수

        while ((lump = countLump()) < 2) {
            if (lump == 0) {
                year = 0;
                break;
            }

            melt();
            year++;
        }

        System.out.println(year);
    }

    private static int countLump() {
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            x = pair.getX();
            y = pair.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] > 0) {
                        queue.offer(new Pair(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    private static void melt() {
        Queue<Pair> queue = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    queue.offer(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int zeroCount = 0;
            int x = pair.getX();
            int y = pair.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] == 0) {
                        zeroCount++;
                    }
                }
            }

            if (map[x][y] - zeroCount < 0) {
                map[x][y] = 0;
            } else {
                map[x][y] -= zeroCount;
            }
        }
    }
}