import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];


        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 심장 위치 찾기
        int heartX = 0;
        int heartY = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (map[i][j] == '*' && map[i - 1][j] == '*' && map[i + 1][j] == '*' && map[i][j - 1] == '*' && map[i][j + 1] == '*') {
                    heartX = i;
                    heartY = j;
                    break;
                }
            }
        }

        int leftArm = count(map, heartX, heartY, 0, -1);
        int rightArm = count(map, heartX, heartY, 0, 1);

        int waist = count(map, heartX, heartY, 1, 0);

        int waistX = heartX + waist;
        int leftLeg = 0;
        for (int i = waistX + 1; i < n; i++) {
            if (map[i][heartY - 1] == '_') {
                break;
            }

            leftLeg++;
        }

        int rightLeg = 0;
        for (int i = waistX + 1; i < n; i++) {
            if (map[i][heartY + 1] == '_') {
                break;
            }

            rightLeg++;
        }


        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }

    private static int count(char[][] map, int x, int y, int dx, int dy) {
        int count = 0;
        int n = map.length;
        x += dx;
        y += dy;

        while (x >= 0 && x < n && y >= 0 && y < n && map[x][y] == '*') {
            count++;
            x += dx;
            y += dy;
        }

        return count;
    }
}