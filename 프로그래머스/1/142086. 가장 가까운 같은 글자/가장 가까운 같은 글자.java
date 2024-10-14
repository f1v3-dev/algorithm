import java.util.*;

class Solution {
    public int[] solution(String s) {
        int len = s.length();
        
        int[] answer = new int[len];
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            
            if (map.containsKey(ch)) {
                answer[i] = i - map.get(ch);
                map.put(ch, i);
            } else {
                answer[i] = -1;
                map.put(ch, i);
            }
        }
        
        return answer;
    }
}