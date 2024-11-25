import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Long> map = new HashMap<>();

        for (int weight : weights) {
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }

        // 1. 같은 값을 가지고 있는 경우
        for (Long value : map.values()) {
            if (value > 1) {
                answer += value * (value - 1) / 2;
            }
        }

        // 2. 3:2, 4:2, 4:3 인 경우
        for (Integer key : map.keySet()) {

            long count = map.get(key);

            if (key * 3 % 2 == 0) {
                int target = key * 3 / 2;
                if (map.containsKey(target)) {
                    answer += count * map.get(target);
                }
            }


            if (key * 4 % 3 == 0) {
                int target = key * 4 / 3;
                if (map.containsKey(target)) {
                    answer += count * map.get(target);
                }
            }

            // 4:2 -> 2:1 은 무조건 계산
            int target = key * 2;
            if (map.containsKey(target)) {
                answer += count * map.get(target);
            }
        }

        return answer;
    }
}
