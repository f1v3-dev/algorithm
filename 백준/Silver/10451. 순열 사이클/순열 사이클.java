import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            solve(n, arr);
        }

    }

    private static void solve(int n, int[] arr) {
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i][0] = i + 1;
            nums[i][1] = arr[i];
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i + 1]) {
                dfs(nums[i][0], nums[i][1], nums, visited);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int cur, int next, int[][] nums, boolean[] visited) {

        if (visited[cur]) {
            return;
        }

        // cur -> next
        visited[cur] = true;
        dfs(next, nums[next - 1][1], nums, visited);
    }

}