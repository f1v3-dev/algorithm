class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        
        for (int[] p : problems) {
            maxAlp = Math.max(maxAlp, p[0]);
            maxCop = Math.max(maxCop, p[1]);
        }
        
        // 현재 능력으로 모든 문제를 풀 수 있는 경우
        if (alp >= maxAlp && cop >= maxCop) {
            return 0;
        }
        
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // 여기까지는 풀 수 있다.
        dp[alp][cop] = 0;
        
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j<= maxCop; j++) {
                
                // 시간을 보내며 알고력 코딩력 향상
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                
                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                // 문제를 풀어서 향상
                for (int[] p : problems) {
                    // 현재 능력으로 해당 문제를 풀 수 있는가?
                    if (i >= p[0] && j >= p[1]) {
                        int nextAlp = Math.min(maxAlp, i + p[2]);
                        int nextCop = Math.min(maxCop, j + p[3]);
                        
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + p[4]);
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
        
    }
}