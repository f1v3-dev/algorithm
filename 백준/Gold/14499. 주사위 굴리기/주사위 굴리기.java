import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int m;
    static int x;
    static int y;
    static int[][] map;
    static int[] dice = new int[6];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        y = Integer.parseInt(input[2]);
        x = Integer.parseInt(input[3]);

        map = new int[n][m];

        int k = Integer.parseInt(input[4]);
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int direction = Integer.parseInt(input[i]);
            move(direction - 1);
        }

        System.out.println(sb);
    }

    private static void move(int direction) {

        // dice[0] : 위
        // dice[1] : 뒤
        // dice[2] : 오른쪽
        // dice[3] : 왼쪽
        // dice[4] : 앞
        // dice[5] : 바닥

        // 만약 주사위의 바닥면이 0이면 주사위의 바닥면에 칸에 쓰여있는 수를 복사한다.
        // 칸에 쓰여있는 수는 0이 된다.

        int[] tempDice = dice.clone();
        int nextX = x + dx[direction];
        int nextY = y + dy[direction];

        if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
            return;
        }

        switch (direction) {
            case 0:
                // 동 : 2 -> 5 -> 3 -> 0 -> 2
                dice[2] = tempDice[0];
                dice[5] = tempDice[2];
                dice[3] = tempDice[5];
                dice[0] = tempDice[3];
                break;

            case 1:
                // 서 : 3 -> 5 -> 2 -> 0 -> 3
                dice[3] = tempDice[0];
                dice[5] = tempDice[3];
                dice[2] = tempDice[5];
                dice[0] = tempDice[2];
                break;

            case 2:
                // 북 : 1 -> 5 -> 4 -> 0 -> 1
                dice[1] = tempDice[0];
                dice[5] = tempDice[1];
                dice[4] = tempDice[5];
                dice[0] = tempDice[4];
                break;

            case 3:
                // 남 : 4 -> 5 -> 1 -> 0 -> 4
                dice[4] = tempDice[0];
                dice[5] = tempDice[4];
                dice[1] = tempDice[5];
                dice[0] = tempDice[1];

                break;
        }

        if (map[nextY][nextX] == 0) {
            map[nextY][nextX] = dice[5];
        } else {
            dice[5] = map[nextY][nextX];
            map[nextY][nextX] = 0;
        }

        x = nextX;
        y = nextY;

        sb.append(dice[0]).append("\n");
    }
}