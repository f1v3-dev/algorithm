import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class Room {
        long t;
        long a;
        long h;

        public Room(long t, long a, long h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    static int n;
    static Room[] rooms;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        rooms = new Room[n];
        long attack = Long.parseLong(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            // [t] 1: 몬스터 | 2: 포션
            long t = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());
            rooms[i] = new Room(t, a, h);
        }

        System.out.println(solve(attack));
    }

    private static long solve(long attack) {

        // 용사의 최소 MaxHP를 구하는 문제
        // 용사의 MaxHP는 1부터 시작한다.

        long left = 0;
        long right = Long.MAX_VALUE;

        // binary search 진행
        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(mid, attack)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean isPossible(long maxHp, long attack) {
        long currentHp = maxHp;

        for (Room room : rooms) {

            long type = room.t;
            if (type == 1) {
                long monsterAttack = room.a;
                long monsterHp = room.h;

                // 내 체력 - 몬스터의 공격력 * 공격 횟수
                // 내가 공격하고 남은 몬스터의 체력이 0이 되는 경우
                if (monsterHp % attack == 0) {
                    currentHp -= monsterAttack * ((monsterHp / attack) - 1);
                } else {
                    currentHp -= monsterAttack * (monsterHp / attack);
                }

                if (currentHp <= 0) {
                    return false;
                }
            } else if (type == 2) {
                // 최대 체력보다 더 높게 회복할 수는 없다.
                currentHp = Math.min(maxHp, currentHp + room.h);
                attack += room.a;
            }
        }

        return true;
    }
}