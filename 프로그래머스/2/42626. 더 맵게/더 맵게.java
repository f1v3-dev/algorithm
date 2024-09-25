import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> queue = new PriorityQueue<>();

        for (int num : scoville) {
            queue.offer(num);
        }

        while (queue.peek() < K) {
            if (queue.size() <= 1) {
                return -1;
            }

            Integer first = queue.poll();
            Integer second = queue.poll();

            int newScoville = first + (second * 2);
            queue.offer(newScoville);

            answer++;
        }

        return answer;
    }
}