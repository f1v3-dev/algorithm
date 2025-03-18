class Solution {

    private static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int result = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i, n);
                result++;
            }
        }

        return result;
    }

    private void dfs(int[][] computers, int target, int n) {

        visited[target] = true;

        for (int i = 0; i < n; i++) {
            if (target != i && computers[target][i] == 1 && !visited[i]) {
                dfs(computers, i, n);
            }
        }
    }

}