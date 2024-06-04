import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {
        Queue<Integer> queue = new LinkedList<>();

        // 1. queue -> push prices
        for (int price : prices) {
            queue.offer(price);
        }

        int[] result = new int[prices.length];

        for (int i = 0; !queue.isEmpty(); i++) {
            int price = queue.poll();
            int count = 0;

            for (int j = i + 1; j < prices.length; j++) {
                if (price <= prices[j]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }

            result[prices.length - queue.size() - 1] = count;
        }


        return result;
    }
}