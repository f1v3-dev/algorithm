import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int m;
    static int n;
    static int h;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[] dz = {-1, 1};

    static int[][][] box;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 3차원 배열
        String[] input = br.readLine().split(" ");
        queue = new LinkedList<>();

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        h = Integer.parseInt(input[2]);

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {

            for (int j = 0; j < n; j++) {
                input = br.readLine().split(" ");

                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(input[k]);
                    box[i][j][k] = num;

                    if (num == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        bfs();
    }

    private static void bfs() {

        int count = -1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int[] current = queue.poll();
                int ch = current[0];
                int cn = current[1];
                int cm = current[2];

                // 상하좌우
                for (int i = 0; i < 4; i++) {
                    int nh = ch;
                    int nn = cn + dx[i];
                    int nm = cm + dy[i];

                    if (nn >= 0 && nn < n && nm >= 0 && nm < m) {
                        if (box[nh][nn][nm] == 0) {
                            box[nh][nn][nm] = 1;
                            queue.offer(new int[]{nh, nn, nm});
                        }
                    }
                }

                // 앞 뒤
                for (int i = 0; i < 2; i++) {
                    int nh = ch + dz[i];
                    int nn = cn;
                    int nm = cm;

                    if (nh >= 0 && nh < h) {
                        if (box[nh][nn][nm] == 0) {
                            box[nh][nn][nm] = 1;
                            queue.offer(new int[]{nh, nn, nm});
                        }
                    }
                }
            }

            count++;
        }

        if (!checkTomato()) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static boolean checkTomato() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}