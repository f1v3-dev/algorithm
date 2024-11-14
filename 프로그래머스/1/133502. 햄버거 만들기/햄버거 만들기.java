import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        // 1: 빵
        // 2: 야채
        // 3: 고기
        
        Stack<Integer> stack = new Stack<>();
        
        for (int ingre : ingredient) {
            stack.push(ingre);
            
            if (stack.size() >= 4
               && stack.get(stack.size() - 4) == 1
               && stack.get(stack.size() - 3) == 2
               && stack.get(stack.size() - 2) == 3
               && stack.get(stack.size() - 1) == 1) {
                answer++;
                
                for (int i = 0; i < 4; i++) {
                    stack.pop();
                }
            }
        }
        
        return answer;
    }
}