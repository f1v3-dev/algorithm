import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int sco : scoville) {
            queue.offer(sco);
        }

        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            Integer first = queue.poll();
            Integer second = queue.poll();
            queue.offer(first + (second * 2));
            answer++;
        }

        return answer;
    }
}