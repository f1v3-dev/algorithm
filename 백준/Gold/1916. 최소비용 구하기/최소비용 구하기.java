import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int next;
    int weight;

    public Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}


public class Main {

    static int n;
    static int m;

    static List<List<Node>> list = new ArrayList<>();
    static int[] weights;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        weights = new int[n + 1];
        Arrays.fill(weights, Integer.MAX_VALUE);


        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            Node node = new Node(end, weight);

            list.get(start).add(node);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int result = solve(start, end);
        System.out.println(result);
    }


    private static int solve(int start, int end) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n + 1];
        weights[start] = 0;

        while (!pq.isEmpty()) {
            Node curNOde = pq.poll();
            int next = curNOde.next;

            if (!visited[next]) {
                visited[next] = true;

                for (Node node : list.get(next)) {

                    int prevWeight = node.weight + weights[next];
                    int currWeight = weights[node.next];

                    if (prevWeight < currWeight) {
                        weights[node.next] = prevWeight;
                        pq.offer(new Node(node.next, prevWeight));
                    }
                }
            }
        }

        return weights[end];
    }
}
