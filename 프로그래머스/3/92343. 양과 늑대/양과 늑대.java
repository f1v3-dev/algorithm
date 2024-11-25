import java.util.*;

class Solution {

    static boolean[][][] visited = new boolean[17][18][18];
    static int[] node;
    static List<List<Integer>> list = new ArrayList<>();
    static int max = 0;

    public int solution(int[] info, int[][] edges) {

        node = info;

        for (int i = 0; i < 17; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            // 양방향
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        dfs(0, 0, 0);

        return max;
    }

    private static void dfs(int depth, int s, int w) {
        if (visited[depth][s][w]) {
            return;
        }

        visited[depth][s][w] = true;

        int prevS = s;
        int prevW = w;
        int prevNode = node[depth];

        if (node[depth] == 0) {
            s++;
        } else if (node[depth] == 1) {
            w++;
        }

        node[depth] = -1;

        if (w < s) {
            max = Math.max(max, s);
            for (Integer next : list.get(depth)) {
                dfs(next, s, w);
            }
        }
        
        node[depth] = prevNode;
        visited[depth][prevS][prevW] = false;
    }
}