import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        // stack에 index 저장
        Stack<Integer> stack = new Stack<>();
        
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = -1;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            
            stack.push(i);
        }
        
        
        return answer;
    }
}