import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Seat implements Comparable<Seat> {

    int x;
    int y;
    int friendCount;
    int emptyCount;

    public Seat(int x, int y, int friendCount, int emptyCount) {
        this.x = x;
        this.y = y;
        this.friendCount = friendCount;
        this.emptyCount = emptyCount;
    }


    @Override
    public int compareTo(Seat o) {
        if (this.friendCount == o.friendCount) {
            if (this.emptyCount == o.emptyCount) {
                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            }
            return o.emptyCount - this.emptyCount;
        }
        return o.friendCount - this.friendCount;
    }
}

public class Main {

    static int n;
    static int[][] map;
    static Map<Integer, List<Integer>> students = new HashMap<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] sequence;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sequence = new int[n * n];
        map = new int[n][n];

        // 입력
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            sequence[i] = student;
            List<Integer> likes = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                likes.add(Integer.parseInt(st.nextToken()));
            }
            students.put(student, likes);
        }

        // 자리 배정
        for (int student : sequence) {
            findSeat(student);
        }

        // 학생의 만족도 총 합 출력
        System.out.println(calcSatisfaction());
    }

    private static void findSeat(int student) {

        // 좋아하는 학생들의 번호를 가져온다.
        List<Integer> likeFriends = students.get(student);

        // 해당 학생이 앉을 수 있는 좌석을 모두 탐색
        List<Seat> seats = new ArrayList<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {

                // 이미 해당 자리에 학생이 앉아있는 경우 제외
                if (map[y][x] != 0) continue;

                int[] counts = countFriendsAndEmptySeats(x, y, likeFriends);
                int friendCount = counts[0];
                int emptyCount = counts[1];
                // 상하좌우 탐색 끝 -> 좌석 추가
                seats.add(new Seat(x, y, friendCount, emptyCount));
            }
        }

        // 우선순위에 따라 정렬
        Collections.sort(seats);

        // 정렬된 좌석에 학생을 배치할 수 있는 경우 배치
        for (Seat seat : seats) {
            int x = seat.x;
            int y = seat.y;
            if (map[y][x] == 0) {
                map[y][x] = student;
                break;
            }
        }
    }

    private static int[] countFriendsAndEmptySeats(int x, int y, List<Integer> likeFriends) {
        int friendCount = 0;
        int emptyCount = 0;

        // 상하좌우로 탐색 시작
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 체크
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            // 주변에 좋아하는 친구가 있는지 확인
            if (likeFriends.contains(map[ny][nx])) {
                friendCount++;
            }

            // 주변에 빈 자리가 있는지 확인
            if (map[ny][nx] == 0) {
                emptyCount++;
            }
        }

        return new int[]{friendCount, emptyCount};
    }

    private static int calcSatisfaction() {

        // 인접한 칸에 앉은 좋아하는 학생의 수
        // 1 : 1, 2 : 10, 3 : 100, 4 : 1000

        int satisfaction = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int student = map[y][x];
                List<Integer> likeFriends = students.get(student);
                int[] friendsAndEmptySeats = countFriendsAndEmptySeats(x, y, likeFriends);
                int friendCount = friendsAndEmptySeats[0];

                if (friendCount > 0) {
                    satisfaction += (int) Math.pow(10, friendCount - 1);
                }
            }
        }

        return satisfaction;
    }
}