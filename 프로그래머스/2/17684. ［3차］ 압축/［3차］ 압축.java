import java.util.*;

class Solution {
    public int[] solution(String msg) {

        Map<String, Integer> dictionary = new HashMap<>();

        // 1. 길이가 1인 모든 단어를 포함하도록 사전 초기화
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(String.valueOf(ch), ch - 'A' + 1);
        }

        List<Integer> output = new ArrayList<>();
        int index = 0;
        
        while (index < msg.length()) {
            StringBuilder str = new StringBuilder();
            
            while (index < msg.length()) {
                if (!dictionary.containsKey(str.toString() + msg.charAt(index))) {
                    break;
                } else {
                    str.append(msg.charAt(index));
                }
                
                index++;
            }
            
            output.add(dictionary.get(str.toString()));
            
            if (index < msg.length()) {
                dictionary.put(str.append(msg.charAt(index)).toString(), dictionary.size() + 1);
            }
        }
        
        
        return output.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}