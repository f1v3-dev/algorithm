import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        for (int val : reserve) {
            reserveSet.add(val);
        }

        for (int val : lost) {
            if (reserveSet.contains(val)) {
                reserveSet.remove(val);
            } else {
                lostSet.add(val);
            }
        }


        for (int val : reserveSet) {
            if (lostSet.contains(val - 1)) {
                lostSet.remove(val - 1);
            } else if (lostSet.contains(val + 1)) {
                lostSet.remove(val + 1);
            }
        }

        return n - lostSet.size();
    }
}
