
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int len = p.length();
        Long val = Long.parseLong(p);
        
        for (int i = 0; i <= t.length() - len; i++) {
            String temp = t.substring(i, i + len);
            if (Long.parseLong(temp) <= val) {
                answer++;
            }
        }
        
        return answer;
    }
}