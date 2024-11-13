class Solution {
    public int solution(int n) {
        
        boolean[] isPrime = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // 에라토스테네스 체 
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 소수 개수 세기
        int answer = 0;
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                answer++;
            }
        }
    
        return answer;
    }
}