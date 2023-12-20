import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            if (stack.empty()) {
                stack.push(num);
            } else if (stack.peek() == num) {
                continue;
            } else {
                stack.push(num);
            }
        }
        
        answer = new int[stack.size()];
        
        while (!stack.empty()) {
            answer[stack.size() - 1] = stack.pop();
        }
        
        return answer;
    }
}