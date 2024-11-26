import java.util.*;

class Solution {
    
    private static class Edge {
        int node;
        int weight;
        
        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<Edge>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 등산로 정보
        for (int[] path : paths) {
            graph[path[0]].add(new Edge(path[1], path[2]));
            graph[path[1]].add(new Edge(path[0], path[2]));
        }
        
        Set<Integer> gateSet = new HashSet<>();
        Set<Integer> summitSet = new HashSet<>();
        
        for (int gate : gates) gateSet.add(gate);
        for (int summit : summits) summitSet.add(summit);
        
        int[] intensities = dijkstra(n, graph, gateSet, summitSet);
        
        int minIntensity = Integer.MAX_VALUE;
        int minSummit = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        
        for (int summit : summits) {
            if (intensities[summit] < minIntensity) {
                minIntensity = intensities[summit];
                minSummit = summit;
            }
        }
        
        return new int[]{minSummit, minIntensity};
    }
    
    private static int[] dijkstra(int n, List<Edge>[] graph, Set<Integer> gateSet, Set<Integer> summitSet) {
        int[] intensities = new int[n + 1];
        Arrays.fill(intensities, Integer.MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        
        for (int gate : gateSet) {
            pq.offer(new Edge(gate, 0));
            intensities[gate] = 0;
        }
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            
            if (cur.weight > intensities[cur.node] || summitSet.contains(cur.node)) {
                continue;
            }
            
            // 인접 노드 탐색
            for (Edge next : graph[cur.node]) {
                if (gateSet.contains(next.node)) {
                    continue;
                }
                
                int maxIntensity = Math.max(intensities[cur.node], next.weight);
                
                if (maxIntensity < intensities[next.node]) {
                    intensities[next.node] = maxIntensity;
                    pq.offer(new Edge(next.node, maxIntensity));
                }
            }
        }
        
        return intensities;
    }
}