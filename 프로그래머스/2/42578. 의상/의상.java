import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] arr : clothes) {
            String key = arr[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        for (Integer value : map.values()) {
            // 선택하지 않은 경우도 + 1
            answer *= value + 1;
        }
        
        // 전체 모두를 선택하지 않은 경우를 빼줘야 한다.
        return answer - 1;
    }
}