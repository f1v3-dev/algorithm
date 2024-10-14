import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        Queue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < k; i++) {
            
            if (i == score.length) {
                break;
            }
            
            queue.offer(score[i]);
            answer[i] = queue.peek();
        }
        
        for (int i = k; i < score.length; i++) {
            int cur = score[i];
            if (queue.peek() < cur) {
                queue.poll();
                queue.offer(cur);
            }
            
            answer[i] = queue.peek();
        }
        
        return answer;
    }
}