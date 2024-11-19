import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> leftSet = new HashSet<>();
        Set<Integer> rightSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int top : topping) {
            leftSet.add(top);
            map.put(top, map.getOrDefault(top, 0) + 1);
        }
        
        for (int top : topping) {
            rightSet.add(top);
            map.put(top, map.get(top) - 1);
            
            if (map.get(top) == 0) {
                leftSet.remove(top);
            }
            
            if (leftSet.size() == rightSet.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}