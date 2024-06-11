import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Move {
    int time;
    char direction;

    public Move(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}

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
    static int k;
    static int l;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Map<Integer, Character> directionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        // 0. map 초기화
        map = new int[n][n];

        // 1. 사과의 위치
        for (int i = 0; i < k; i++) {
            String[] apple = br.readLine().split(" ");
            int x = Integer.parseInt(apple[0]) - 1;
            int y = Integer.parseInt(apple[1]) - 1;

            // 사과가 있는 위치를 1로 표시한다.
            map[x][y] = 1;
        }

        // 2. 뱀의 방향 변환 정보
        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] dir = br.readLine().split(" ");
            int x = Integer.parseInt(dir[0]);
            char c = dir[1].charAt(0);

            directionMap.put(x, c);
        }

        solve();
    }

    private static void solve() {

        int time = 0;
        int headDirection = 0;

        // 뱀의 위치 정보를 저장하는 큐
        Deque<Position> snake = new LinkedList<>();
        snake.offer(new Position(0, 0));

        // 방향이 바뀌는 지점 정보
        boolean[][] changedPosition = new boolean[n][n];

        // 초기 뱀의 위치는 (0, 0), 방향은 오른쪽
        while (true) {

            // 1. 시간재기
            time++;

            // 2. 뱀 이동
            Position head = snake.peek();
            int x = head.x + dx[headDirection];
            int y = head.y + dy[headDirection];

            // 3. 종료 조건 체크
            if (isBlocked(x, y) || isTouchBody(x, y, snake)) {
                break;
            }

            // 4. 사과 먹기
            if (map[x][y] == 1) {
                map[x][y] = 0;
                snake.offerFirst(new Position(x, y));
            } else {
                snake.offerFirst(new Position(x, y));
                snake.pollLast();
            }

            // 5. 방향 전환
            if (directionMap.containsKey(time)) {
                char direction = directionMap.get(time);
                if (direction == 'L') {
                    headDirection = (headDirection + 3) % 4;
                } else {
                    headDirection = (headDirection + 1) % 4;
                }
            }
        }

        System.out.println(time);
    }

    private static boolean isBlocked(int nextX, int nextY) {
        return nextX < 0 || nextX >= n || nextY < 0 || nextY >= n;
    }

    private static boolean isTouchBody(int nextX, int nextY, Deque<Position> snake) {

        // 뱀의 머리가 다음 위치로 이동했을 때 몸통과 닿는지 확인
        for (Position position : snake) {
            if (position.x == nextX && position.y == nextY) {
                return true;
            }
        }

        return false;
    }
}