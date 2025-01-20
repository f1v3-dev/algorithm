import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int h;
    int n;
    int m;

    public Tomato(int h, int n, int m) {
        this.h = h;
        this.n = n;
        this.m = m;
    }
}

public class Main {

    static int m, n, h;
    static int[][][] box;
    static Queue<Tomato> queue = new LinkedList<>();
    static int remainTomato = 0;

    // 상하좌우 앞뒤
    static final int[][] DIRECTIONS = {
            {0, 0, -1},
            {0, 0, 1},
            {0, -1, 0},
            {0, 1, 0},
            {-1, 0, 0},
            {1, 0, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if (box[i][j][k] == 1) {
                        queue.offer(new Tomato(i, j, k));
                    } else if (box[i][j][k] == 0) {
                        remainTomato++;
                    }
                }
            }
        }

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() {

        if (remainTomato == 0) {
            return 0;
        }

        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            while (size-- > 0) {
                Tomato current = queue.poll();

                for (int[] dir : DIRECTIONS) {
                    int nh = current.h + dir[0];
                    int nn = current.n + dir[1];
                    int nm = current.m + dir[2];

                    if (isValid(nh, nn, nm) && box[nh][nn][nm] == 0) {
                        box[nh][nn][nm] = 1;
                        queue.offer(new Tomato(nh, nn, nm));
                        remainTomato--;
                    }
                }
            }
        }

        return remainTomato == 0 ? days : -1;
    }

    private static boolean isValid(int nh, int nn, int nm) {
        return nh >= 0 && nh < h
                && nn >= 0 && nn < n
                && nm >= 0 && nm < m;
    }
}