import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(max);
    }

    private static void solve() {
        // 벽 3개를 세운 경우, spreadVirus() -> findSafetyZone() -> max 갱신
        findOptimalWall(0);
    }

    private static void findOptimalWall(int depth) {

        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    findOptimalWall(depth + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    private static void spreadVirus() {

        Queue<Position> queue = new LinkedList<>();

        // virus 위치를 queue에 추가
        addVirus(queue);

        // copyMap 생성
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, m);
        }

        // bfs 진행
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int cx = position.x;
            int cy = position.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (copyMap[nx][ny] == 0) {
                    queue.add(new Position(nx, ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }

        // 안전구역 찾기
        max = Math.max(max, findSafetyZone(copyMap));
    }

    private static void addVirus(Queue<Position> queue) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Position(i, j));
                }
            }
        }
    }

    private static int findSafetyZone(int[][] copyMap) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}