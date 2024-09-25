import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {

        Queue<Integer> minQueue = new PriorityQueue<>();
        Queue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String[] split = operation.split(" ");
            String op = split[0];
            int value = Integer.parseInt(split[1]);

            switch (op) {
                case "I" -> {
                    minQueue.offer(value);
                    maxQueue.offer(value);
                }
                case "D" -> {
                    if (value == 1 && (!maxQueue.isEmpty())) {
                        Integer max = maxQueue.poll();
                        minQueue.remove(max);
                    }

                    if (value == -1 && (!minQueue.isEmpty())) {
                        Integer min = minQueue.poll();
                        maxQueue.remove(min);
                    }
                }
            }
        }
        int[] answer = new int[2];

        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer[0] = maxQueue.poll();
            answer[1] = minQueue.poll();
        }

        return answer;
    }
}