class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int start = section[0];
        int end = start + (m - 1);
        
        for (int num : section) {
            if (start <= num && num <= end) {
                continue;
            } else {
                start = num;
                end = num + (m - 1);
                answer++;
            }
        }
        return answer;
    }
}