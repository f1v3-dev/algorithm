import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // 양방향 연결
            list.get(a).add(b);
            list.get(b).add(a);
        }

        solve(n, m, list);
    }

    private static void solve(int n, int m, List<List<Integer>> list) {

        int minCost = Integer.MAX_VALUE;
        int minPerson = 0;

        for (int currentPerson = 1; currentPerson <= n; currentPerson++) {
            int totalCost = bfs(list, n, currentPerson);

            if (totalCost < minCost) {
                minCost = totalCost;
                minPerson = currentPerson;
            }
        }

        System.out.println(minPerson);
    }

    private static int bfs(List<List<Integer>> list, int n, int start) {

        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        int[] distance = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        // m == count
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Integer next : list.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i != start) {
                sum += distance[i];
            }
        }

        return sum;
    }

}