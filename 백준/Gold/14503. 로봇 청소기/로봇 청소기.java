import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int x, y, d;
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(x, y, d);
        System.out.println(count);
    }


    private static void solve(int r, int c, int direction) {

        // 1. 현재 칸이 청소되지 않은 경우 현재 칸 청소
        // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        // 2-1. 바라보는 방향을 유지한 채로 한 칸을 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        // 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
        // 3-1. 반시계 방향으로 90도 회전한다.
        // 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        // 3-3. 1번으로 돌아간다.


        // 1번 조건
        if (map[r][c] == 0) {
            // 청소가 되었다고 표시
            map[r][c] = -1;
            count++;
        }

        // 2 & 3번 조건 체크
        boolean isClean = true;
        for (int i = 0; i < 4; i++) {
            int nextDirection = (direction + 3 - i) % 4;
            int nextR = r + dr[nextDirection];
            int nextC = c + dc[nextDirection];

            if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) {
                continue;
            }

            // 3번 조건
            if (map[nextR][nextC] == 0) {
                isClean = false;
                break;
            }
        }

        if (isClean) {
            // 뒤쪽 방향
            int backDirection = (direction + 2) % 4;
            int backR = r + dr[backDirection];
            int backC = c + dc[backDirection];

            if (backR < 0 || backC < 0 || backR >= n || backC >= m || map[backR][backC] == 1) {
                return;
            }

            solve(backR, backC, direction);
        } else {
            // 반시계 방향으로 90도 회전
            int nextDirection = (direction + 3) % 4;
            int nextR = r + dr[nextDirection];
            int nextC = c + dc[nextDirection];

            if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) {
                return;
            }

            if (map[nextR][nextC] == 0) {
                solve(nextR, nextC, nextDirection);
            } else {
                solve(r, c, nextDirection);
            }
        }
    }
}