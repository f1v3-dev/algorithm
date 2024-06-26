import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int m;
    static int n;
    static int[] parents;
    static List<Node> nodes = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) {
                break;
            }

            parents = new int[n + 1];

            int totalCost = 0;


            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                nodes.add(new Node(start, end, cost));

                totalCost += cost;
            }

            // 비용을 기준으로 정렬 (크루스칼 알고리즘 적용을 위해)
            Collections.sort(nodes);

            int minCost = solve();
            sb.append(totalCost - minCost).append("\n");
            nodes.clear();
        }

        System.out.println(sb);
    }

    private static int solve() {
        int minCost = 0;
        int count = 0;

        make();

        // find-union
        for (Node node : nodes) {
            if (isUnion(node.start, node.end)) {
                minCost += node.cost;
                count++;
            }

            if (count == m - 1) {
                break;
            }
        }

        return minCost;
    }

    private static void make() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    private static int find(int v) {
        if (parents[v] == v) {
            return v;
        }

        parents[v] = find(parents[v]);
        return parents[v];
    }

    private static boolean isUnion(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = a;
        return true;
    }
}