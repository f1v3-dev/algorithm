class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int [] arr = new int[n];
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 1) {
                arr[count++] = i;
            }
        }
        answer = arr[0];
        return answer;
    }
}