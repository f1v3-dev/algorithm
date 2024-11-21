import java.util.*;

class Solution {
    int solution(int[][] land) {
        

        int[][] dp = new int[land.length][land[0].length];
        
        // 최상위 열은 그대로 복사한다.
        for (int i = 0; i < land[0].length; i++) {
            dp[0][i] = land[0][i];
        }
        
        // 각 행을 돌면서 상위 행의 최댓값과 현재 값을 더해준다.
        // 이 때, 같은 열은 선택할 수 없는 것 주의
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                
                for (int k = 0; k < land[i].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                }
            }
        }
        
        return Arrays.stream(dp[dp.length - 1])
            .max()
            .getAsInt();
    }
}