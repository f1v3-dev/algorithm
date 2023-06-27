class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int num = 2 * a * b;
        String str = Integer.toString(a) + Integer.toString(b);
        
        answer = Math.max(num, Integer.parseInt(str));
        return answer;
    }
}