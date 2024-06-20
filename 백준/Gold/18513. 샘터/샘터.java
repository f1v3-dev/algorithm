import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int unfortunate;

    public Point(int x, int unfortunate) {
        this.x = x;
        this.unfortunate = unfortunate;
    }
}

public class Main {

    static int n;
    static int k;
    static int[] arr;
    static Set<Integer> visited = new HashSet<>();
    static int[] dx = {1, -1};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            visited.add(arr[i]);
        }

        System.out.println(solve());
    }

    private static long solve() {

        // k : 집의 수
        // n : 샘터의 수
        // arr : 샘터의 위치 (n개)

        // 불행도 : 집에서 샘터까지 거리 (집의 위치 - 샘터의 위치)
        // 불행도의 합을 최소로 하기 -> 샘터의 위치 주변에 집이 위치해야 함

        // bfs를 사용해서 좌, 우로 이동하면서 불행도를 계산
        // 방문처리를 배열로 할 경우 음수에 대한 처리가 불가능 -> Set으로 변경
        return bfs();
    }

    private static long bfs() {

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Point(arr[i], 0));
        }

        int homeCount = 0;
        long totalUnfortunate = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int unfortunate = point.unfortunate;

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];

                if (homeCount == k) {
                    continue;
                }

                if (!visited.contains(nx)) {
                    visited.add(nx);
                    queue.offer(new Point(nx, unfortunate + 1));
                    totalUnfortunate += unfortunate + 1;
                    homeCount++;
                }
            }
        }

        return totalUnfortunate;
    }
}