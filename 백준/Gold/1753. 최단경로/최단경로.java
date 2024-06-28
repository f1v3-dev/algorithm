import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {

        // 도착 지험
        int index;

        // 비용
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            // 최소 비용 구하기
            return this.cost - o.cost;
        }
    }

    static int v;
    static int e;
    static List<List<Node>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 시작지점 u 에서 v까지의 w 비용
            graph.get(u).add(new Node(v, w));
        }

        solve(start);
    }

    private static void solve(int start) {

        PriorityQueue<Node> queue = new PriorityQueue<>();

        // 최단경로를 저장할 배열
        int[] dist = new int[v + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        // 시작 지점을 정하기
        dist[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 현재의 최소비용보다 꺼낸 노드의 비용이 더 크다면 비교할 필요가 없음.
            if (dist[current.index] < current.cost) {
                continue;
            }

            // 현재 노드에서 갈 수 있는 다음 노드들을 방문
            List<Node> nextList = graph.get(current.index);
            for (Node next : nextList) {

                int totalCost = next.cost + current.cost;
                if (dist[next.index] > totalCost) {
                    dist[next.index] = totalCost;
                    queue.offer(new Node(next.index, totalCost));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
    
}
