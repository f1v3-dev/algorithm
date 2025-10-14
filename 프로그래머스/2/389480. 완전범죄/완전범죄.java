class Solution {
    public int solution(int[][] info, int n, int m) {
        Integer[][][] memo = new Integer[info.length][n][m];
        
        int result = dfs(info, 0, 0, 0, n, m, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int dfs(int[][] info, int idx, int aCount, int bCount, int n, int m, Integer[][][] memo) {
        
        if (idx == info.length) {
            return aCount;
        }
        
        if (memo[idx][aCount][bCount] != null) {
            return memo[idx][aCount][bCount];
        }
        
        int result = Integer.MAX_VALUE;
        
        // 선택 1. A에 흔적
        if (aCount + info[idx][0] < n) {
            int choiceA = dfs(info, idx + 1, aCount + info[idx][0], bCount, n, m, memo);
            result = Math.min(choiceA, result);
        }
        
        // 선택 2. B에 흔적
        if (bCount + info[idx][1] < m) {
            int choiceB = dfs(info, idx + 1, aCount, bCount + info[idx][1], n, m, memo);
            result = Math.min(choiceB, result);
        }
        
        memo[idx][aCount][bCount] = result;
        return result;
    }
}