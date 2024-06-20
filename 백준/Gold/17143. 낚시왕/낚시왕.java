import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Shark {
    int r;
    int c;
    int speed;
    int direction;
    int size;

    public Shark(int r, int c, int speed, int direction, int size) {
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}

public class Main {


    static int r;
    static int c;
    static int m;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};
    static List<Shark> sharks = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // d -> 1: 위 2: 아래 3: 오른쪽 4: 왼쪽
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            sharks.add(new Shark(r, c, speed, direction, size));
        }

        solve();
    }

    private static void solve() {

        int result = 0;

        // 1. 낚시왕 오른쪽 한 칸 이동
        for (int fisher = 1; fisher <= c; fisher++) {

            if (sharks.isEmpty()) {
                break;
            }

            // 2. 낚시왕이 있는 열에 있는 상어 중 땅과 제일 가까운 상어 잡기
            // 2-1. 해당 상어 list에서 제거 후 catchedSharks에 추가
            Shark catchedShark = null;
            for (Shark shark : sharks) {
                if (shark.c == fisher) {
                    if (Objects.isNull(catchedShark) || shark.r < catchedShark.r) {
                        catchedShark = shark;
                    }
                }
            }

            if (Objects.nonNull(catchedShark)) {
                result += catchedShark.size;
                sharks.remove(catchedShark);
            }

            // 3. 상어 이동
            moveShark();
        }

        System.out.println(result);
    }

    private static void moveShark() {
        // 상어는 주어진 속도로 이동
        // 이동하려는 칸이 격자판의 경계를 넘는 경우 방향을 반대로 변경
        sharks.forEach(Main::move);

        // 같은 위치에 있는 상어 중 크기가 가장 큰 상어만 남기기
        Map<String, Shark> sharkMap = new HashMap<>();
        for (Shark shark : sharks) {
            String key = shark.r + " " + shark.c;
            if (sharkMap.containsKey(key)) {
                Shark existShark = sharkMap.get(key);
                if (existShark.size < shark.size) {
                    sharkMap.put(key, shark);
                }
            } else {
                sharkMap.put(key, shark);
            }
        }

        sharks = new ArrayList<>(sharkMap.values());
    }

    private static void move(Shark shark) {

        int speed = shark.speed;

        if (shark.direction == 1 || shark.direction == 2) {
            speed = speed % (2 * (r - 1));
        } else if (shark.direction == 3 || shark.direction == 4) {
            speed = speed % (2 * (c - 1));
        }

        while (speed > 0) {
            int nr = shark.r + dr[shark.direction];
            int nc = shark.c + dc[shark.direction];

            if (nr < 1 || nc < 1 || nr > r || nc > c) {
                shark.direction = turn(shark.direction);
                continue;
            }

            shark.r = nr;
            shark.c = nc;
            speed--;
        }
    }

    private static int turn(int direction) {
        if (direction == 1) return 2;
        if (direction == 2) return 1;
        if (direction == 3) return 4;
        if (direction == 4) return 3;

        throw new IllegalArgumentException("잘못된 방향입니다.");
    }

}