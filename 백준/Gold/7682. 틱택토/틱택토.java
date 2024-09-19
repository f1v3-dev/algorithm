import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[][] map = new char[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;

        while (!(input = br.readLine()).equals("end")) {

            int xCount = 0;
            int oCount = 0;

            for (int i = 0; i < 9; i++) {
                char ch = input.charAt(i);
                map[i / 3][i % 3] = ch;

                if (ch == 'X') {
                    xCount++;
                } else if (ch == 'O') {
                    oCount++;
                }
            }

            boolean xWin = isWin('X');
            boolean oWin = isWin('O');

            // x가 이기는 경우: x가 o보다 1개 많음
            if (xWin && !oWin && xCount == oCount + 1) {
                sb.append("valid").append("\n");
            }

            // o가 이기는 경우: x와 o의 개수가 같음
            else if (!xWin && oWin && xCount == oCount) {
                sb.append("valid").append("\n");
            }

            // 비기는 경우: x 5개, o 4개
            else if (!xWin && !oWin && xCount == 5 && oCount == 4) {
                sb.append("valid").append("\n");
            }

            // 그외 : invalid
            else {
                sb.append("invalid").append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == player && map[i][1] == player && map[i][2] == player) {
                return true;
            }
            if (map[0][i] == player && map[1][i] == player && map[2][i] == player) {
                return true;
            }
        }

        // 대각선 체크
        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) {
            return true;
        }

        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) {
            return true;
        }

        return false;
    }
}