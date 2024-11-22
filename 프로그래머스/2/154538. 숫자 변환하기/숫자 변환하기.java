import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {

        if (x == y) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});

        boolean[] visited = new boolean[y + 1];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int value = current[0];
            int count = current[1];

            int[] nextValue = {value + n, value * 2, value * 3};
            for (int next : nextValue) {

                if (next == y) {
                    return count + 1;
                }

                if (next <= y && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }
        }

        return -1;
    }
}