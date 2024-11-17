import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int day = 10;

        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < day; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        for (int i = 0; i <= discount.length - day; i++) {
            boolean isBuy = true;
            for (String key : wantMap.keySet()) {
                if (wantMap.get(key) > discountMap.getOrDefault(key, 0)) {
                    isBuy = false;
                    break;
                }
            }

            if (isBuy) {
                answer++;
            }

            if (i + day < discount.length) {
                discountMap.put(discount[i], discountMap.get(discount[i]) - 1);
                if (discountMap.get(discount[i]) == 0) {
                    discountMap.remove(discount[i]);
                }
                discountMap.put(discount[i + day], discountMap.getOrDefault(discount[i + day], 0) + 1);
            }
        }

        return answer;
    }
}