import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    public int redX;
    public int redY;
    public int blueX;
    public int blueY;
    public int count;

    public Pair(int redX, int redY, int blueX, int blueY, int count) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.count = count;
    }
}

public class Main {

    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int rx = 0;
    static int ry = 0;
    static int bx = 0;
    static int by = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 1. map 초기화
        visited = new boolean[n][m][n][m];
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == '#') {
                    visited[i][j][i][j] = true;
                } else if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        solve();
    }

    private static void solve() {

        // bfs 방식으로 풀어야 될 것 같음.
        // 1. R이 O에 도착하면 종료
        // 2. #은 벽, .은 이동 가능
        // 3. R과 B가 동시에 이동해야 함 (상하좌우)
        // 4. 이동은 벽을 만날때까지 이동
        // 5. R과 B의 위치는 겹칠 수 없음.

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(rx, ry, bx, by, 1));

        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {

            Pair pair = queue.poll();

            if (pair.count > 10) {
                return -1;
            }

            int redX = pair.redX;
            int redY = pair.redY;
            int blueX = pair.blueX;
            int blueY = pair.blueY;

            for (int i = 0; i < 4; i++) {

                int nrx = redX;
                int nry = redY;
                int nbx = blueX;
                int nby = blueY;

                boolean redFlag = false;
                boolean blueFlag = false;

                // 빨간 구슬 이동
                while (map[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];

                    if (map[nrx][nry] == 'O') {
                        redFlag = true;
                        break;
                    }
                }

                // 파란 구슬 이동
                while (map[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];

                    if (map[nbx][nby] == 'O') {
                        blueFlag = true;
                        break;
                    }
                }
                
                // 종료 조건 체크 (파란 구슬이 O에 도착하면 안되는 것을 고려)
                if (blueFlag) {
                    continue;
                }

                if (redFlag && !blueFlag) {
                    return pair.count;
                }

                // 빨간 구슬과 파란 구슬이 겹치는 경우
                if (nrx == nbx && nry == nby) {
                    if (i == 0) {
                        if (redX > blueX) {
                            nrx -= dx[i];
                        } else {
                            nbx -= dx[i];
                        }
                    } else if (i == 1) {
                        if (redY < blueY) {
                            nry -= dy[i];
                        } else {
                            nby -= dy[i];
                        }
                    } else if (i == 2) {
                        if (redX < blueX) {
                            nrx -= dx[i];
                        } else {
                            nbx -= dx[i];
                        }
                    } else {
                        if (redY > blueY) {
                            nry -= dy[i];
                        } else {
                            nby -= dy[i];
                        }
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.offer(new Pair(nrx, nry, nbx, nby, pair.count + 1));
                }
            }
        }

        return -1;
    }
}