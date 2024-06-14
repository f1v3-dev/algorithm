import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        System.out.println(min);
    }

    private static void solve() {
        // 총 인원 : n
        // 1. 두 팀으로 나누어 서로의 능력치 차이가 최소가 되도록

        // backtracking
        for (int i = 0; i < n; i++) {
            visited[i] = true;
            backtracking(i + 1, 1);
            visited[i] = false;
        }
    }

    private static void backtracking(int index, int count) {
        if (count == n / 2) {

            // 1. start 팀과 link 팀으로 나누기
            int start = 0;
            int link = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i] && visited[j]) {
                        start += arr[i][j];
                    } else if (!visited[i] && !visited[j]) {
                        link += arr[i][j];
                    }
                }
            }

            // 2. 능력치 차이 구하기
            int difference = Math.abs(start - link);
            min = Math.min(min, difference);
        }

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}