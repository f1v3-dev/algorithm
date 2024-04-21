import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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

    private static int r; // r : Row
    private static int c; // c : Column
    private static char[][] map; // 지도
    private static final Queue<Pair> jQueue = new LinkedList<>(); // 지훈 queue
    private static final Queue<Pair> fQueue = new LinkedList<>(); // 불 queue
    private static int[][] jDist;
    private static int[][] fDist;
    private static int[] dx = {-1, 1, 0, 0,};
    private static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 지도 초기화
        map = new char[r][c];
        jDist = new int[r][c];
        fDist = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                jDist[i][j] = -1;
                fDist[i][j] = -1;

                if (map[i][j] == 'J') {
                    jQueue.offer(new Pair(i, j));
                    jDist[i][j] = 0;
                }

                if (map[i][j] == 'F') {
                    fQueue.offer(new Pair(i, j));
                    fDist[i][j] = 0;
                }

            }
        }

        bfs();
    }

    private static void bfs() {
        fireBfs();
        jihoonBfs();
    }

    /**
     * 불에 대한 bfs method.
     */
    private static void fireBfs() {

        while (!fQueue.isEmpty()) {
            Pair pair = fQueue.poll();
            int x = pair.getX();
            int y = pair.getY();

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                if (xx >= 0 && yy >= 0 && xx < r && yy < c) {
                    if (fDist[xx][yy] >= 0 || map[xx][yy] == '#') {
                        continue;
                    }

                    fDist[xx][yy] = fDist[x][y] + 1;
                    fQueue.offer(new Pair(xx, yy));
                }
            }
        }
    }

    /**
     * 지훈에 대한 bfs method.
     */
    private static void jihoonBfs() {
        while (!jQueue.isEmpty()) {
            Pair pair = jQueue.poll();
            int x = pair.getX();
            int y = pair.getY();

            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];

                // 범위를 벗어남 = 탈출
                if (xx < 0 || yy < 0 || xx >= r || yy >= c) {
                    System.out.println(jDist[x][y] + 1);
                    return;
                }

                if (jDist[xx][yy] >= 0 || map[xx][yy] == '#') {
                    continue;
                }

                if (fDist[xx][yy] <= jDist[x][y] + 1 && fDist[xx][yy] != -1) {
                    continue;
                }

                jDist[xx][yy] = jDist[x][y] + 1;
                jQueue.offer(new Pair(xx, yy));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}