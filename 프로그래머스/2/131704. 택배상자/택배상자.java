import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 1; i <= order.length; i++) {
            queue.offer(i);
        }
        
        boolean isContinue = true;
        for (int target : order) {
            
            if (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                answer++;
                continue;
            }
            
            if (!isContinue) {
                break;
            }
            
            while (!queue.isEmpty()) {
                int num = queue.poll();
                
                if (num == target) {
                    answer++;
                    break;
                } else {
                    stack.push(num);
                }
            }
            
            if (queue.isEmpty()) {
                isContinue = false;
            }
        }
        
        return answer;
    }
}