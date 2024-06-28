import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static class Area implements Comparable<Area> {
        int vertex;
        int mcdonald;
        int starbucks;

        public Area(int vertex, int mcdonald, int starbucks) {
            this.vertex = vertex;
            this.mcdonald = mcdonald;
            this.starbucks = starbucks;
        }

        @Override
        public int compareTo(Area o) {
            return (this.mcdonald + this.starbucks) - (o.mcdonald + o.starbucks);
        }
    }

    static int v;
    static int e;
    static List<List<Node>> graph;
    static int[] mcdonald;
    static int mcdonaldAreaCost;
    static int[] starbucks;
    static int starbucksAreaCost;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 맥세권 : 맥도날드와 집 사이 최단거리 = x
        // 스세권 : 스타벅스와 집 사이 최단거리 = y
        // 맥세권 + 스세권 중 최단거리 합이 최소인 집
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 도로의 정보
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 양방향 그래프로 만들기
            graph.get(start).add(new Node(end, cost));
            graph.get(end).add(new Node(start, cost));
        }

        // 맥도날드의 수 M, 맥세권일 조건 x
        // M개의 맥도날드 정점 번호
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        mcdonald = new int[m];
        mcdonaldAreaCost = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mcdonald[i] = Integer.parseInt(st.nextToken());
        }


        // 스타벅스의 수 S, 스세권일 조건 y
        // S개의 스타벅스 정점 번호
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        starbucks = new int[s];
        starbucksAreaCost = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            starbucks[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    private static void solve() {

        // 1. 맥세권 찾기
        int[] mcdonaldArea = findArea(mcdonald, mcdonaldAreaCost);

        // 2. 스세권 찾기
        int[] starbucksArea = findArea(starbucks, starbucksAreaCost);

        // 3. 맥세권이면서 스세권인 곳 찾기
        List<Area> areaList = new ArrayList<>();
        for (int i = 1; i < v + 1; i++) {
            if (mcdonaldArea[i] != Integer.MAX_VALUE &&
                    mcdonaldArea[i] <= mcdonaldAreaCost &&
                    starbucksArea[i] != Integer.MAX_VALUE &&
                    starbucksArea[i] <= starbucksAreaCost) {
                areaList.add(new Area(i, mcdonaldArea[i], starbucksArea[i]));
            }
        }

        // 4. 맥 + 스세권이 여러개인 경우 가장 작은 것의 vertex 출력
        if (areaList.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(areaList);
        System.out.println(areaList.get(0).mcdonald + areaList.get(0).starbucks);

    }

    private static int[] findArea(int[] locations, int areaCost) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (int location : locations) {
            dist[location] = 0;
            queue.offer(new Node(location, 0));
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.cost > dist[current.index]) {
                continue;
            }


            for (Node next : graph.get(current.index)) {
                int totalCost = current.cost + next.cost;

                if (totalCost < dist[next.index] && totalCost <= areaCost) {
                    dist[next.index] = totalCost;
                    queue.offer(new Node(next.index, totalCost));
                }
            }
        }

        for (int location : locations) {
            dist[location] = Integer.MAX_VALUE;
        }

        return dist;
    }
}