import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(1, s.length() - 1);
        String[] arr = s.split("},");
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (String str : arr) {
            str = str.replace("{", "").replace("}", "");
            
            String[] numbers = str.split(",");
            List<Integer> list = new ArrayList<>();
            for (String num : numbers) {
                list.add(Integer.parseInt(num));
            }
            
            map.put(list.size(), list);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i <= map.size(); i++) {
            List<Integer> numbers = map.get(i);
            
            for (int number : numbers) {
                if (!answer.contains(number)) {
                    answer.add(number);
                }
            }
        }
        
        
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}