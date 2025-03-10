class Solution {
    public long solution(int n) {

        long[] dp = new long[n + 1];

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567L;
        }

        return dp[n];
    }
}