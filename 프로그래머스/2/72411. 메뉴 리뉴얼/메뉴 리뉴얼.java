import java.util.*;

class Solution {
    
    static List<Map<String, Integer>> foodMap = new ArrayList<>();
    static int[] maxCount = new int[11];
    
    public String[] solution(String[] orders, int[] course) {
        
        for (int i = 0; i < 11; i++) {
            foodMap.add(new HashMap<>());
        }
        
        // combination
        for (String order : orders) {
            char[] arr = order.toCharArray();
            
            Arrays.sort(arr);
            combination(arr, 0, new StringBuilder());
        }
        
        List<String> result = new ArrayList<>();
        for (int len : course) {
            for (Map.Entry<String, Integer> entry : foodMap.get(len).entrySet()) {
                if (entry.getValue() >= 2 && entry.getValue() == maxCount[len]) {
                    result.add(entry.getKey());
                }
            }
        }
        
        Collections.sort(result);
        
        String[] answer = new String[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    private static void combination(char[] arr, int depth, StringBuilder sb) {
        
        if (depth == arr.length) {
            int len = sb.length();
            
            if (len >= 2) {
                int count = foodMap.get(len).getOrDefault(sb.toString(), 0) + 1;
                foodMap.get(len).put(sb.toString(), count);
                
                maxCount[len] = Math.max(maxCount[len], count);
            }
            
            return;
        }
        
        combination(arr, depth + 1, sb.append(arr[depth]));
        sb.setLength(sb.length() - 1);
        combination(arr, depth + 1, sb);
    }
}