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

    static int v;
    static int e;
    static int[] parents;
    static List<Node> nodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parents = new int[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            nodes.add(new Node(start, end, cost));
        }

        Collections.sort(nodes);
        System.out.println(solve());
    }

    private static int solve() {
        make();


        // find-union 과정을 거쳐 최소 스패닝 트리 구하기
        int result = 0;
        int count = 0;

        for (Node node : nodes) {
            if (find(node.start) != find(node.end)) {
                union(node.start, node.end);
                result += node.cost;
                count++;

                // 만약 모든 노드가 연결되었다면 종료한다.
                if (count == v - 1) {
                    break;
                }
            }
        }

        return result;
    }


    private static void make() {
        for (int i = 0; i < v; i++) {
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


    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if (aRoot == bRoot) {
            return;
        }
        
        parents[aRoot] = b;
    }
}