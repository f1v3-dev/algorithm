import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        // 우선순위 큐 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());


        for (String operation : operations) {
            String[] op = operation.split(" ");
            String command = op[0];
            int value = Integer.parseInt(op[1]);

            switch (command) {
                case "I":
                    minHeap.add(value);
                    maxHeap.add(value);
                    break;

                case "D":
                    // 큐에서 최댓값 삭제
                    if (value == 1 && (!maxHeap.isEmpty())) {
                        Integer max = maxHeap.poll();
                        minHeap.remove(max);
                    }

                    // 큐에서 최솟값 삭제
                    if (value == -1 && (!minHeap.isEmpty())) {
                        Integer min = minHeap.poll();
                        maxHeap.remove(min);
                    }
                    break;
                    
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        }

        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }
}