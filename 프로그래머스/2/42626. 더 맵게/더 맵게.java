import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int sco : scoville) {
            pq.offer(sco);
        }
        
        while (!pq.isEmpty() && !(pq.peek() >= K)) {
            
            int first = pq.poll();
            
            if (pq.isEmpty()) {
                break;
            }
            
            int second = pq.poll();
            
            pq.offer(first + (second * 2));
            answer++;
        }
        
        if (pq.isEmpty()) {
            return -1;
        }
        
        return answer;
    }
}