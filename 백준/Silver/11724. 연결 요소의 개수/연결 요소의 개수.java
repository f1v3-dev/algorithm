import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static boolean[] visited;

    private static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 방문 체크 배열
        visited = new boolean[N + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        list = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            // 양 방향으로 add
            list[start].add(end);
            list[end].add(start);
        }

        int totalCount = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                totalCount++;
                DFS(i);
            }
        }

        System.out.println(totalCount);
    }

    private static void DFS(int num) {

        if (visited[num]) {
            return;
        }

        visited[num] = true;
        for (Integer i : list[num]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}