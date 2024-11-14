import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        Arrays.sort(lottos);

        Set<Integer> set = new HashSet<>();
        for (int num : win_nums) {
            set.add(num);
        }

        int match = 0;
        int zero = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }

            if (set.contains(lotto)) {
                match++;
            }
        }

        // 1등 : 6, 2등 : 5, 3등 : 4, 4등 : 3, 5등 : 2, 6등 그외

        int max = Math.min(7 - (match + zero), 6);
        int min = Math.min(7 - match, 6);

        return new int[]{max, min};
    }
}