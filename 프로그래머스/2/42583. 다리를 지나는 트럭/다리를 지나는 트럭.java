import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int totalWeight = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (bridge.size() == bridge_length) {
                    totalWeight -= bridge.poll();
                }

                if (totalWeight + truck <= weight) {
                    bridge.offer(truck);
                    totalWeight += truck;
                    time++;
                    break;
                } else {
                    bridge.offer(0);
                    time++;
                }
            }
        }


        time += bridge_length;

        return time;
    }
}