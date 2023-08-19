import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int dfs(ArrayList<Integer>[] graph, boolean[] visited, int node){
        int count = 0;

        visited[node] = true;

        for (int num : graph[node]) {
            if (!visited[num]) {
                count += dfs(graph, visited, num) + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        int X = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N + 1];
        int count = dfs(graph, visited, X);

        System.out.println(count);
    }

}