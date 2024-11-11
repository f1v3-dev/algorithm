class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char ch = s.charAt(0);
        boolean isPositive = true;
        if (ch == '-') {
            isPositive = false;
        }
        
        // 부호가 있다면 부호를 떼준다.
        if (ch == '+' || ch == '-') {
            s = s.substring(1, s.length());
        }
        
        answer = Integer.parseInt(s);
        return isPositive ? answer : -answer;
    }
}