import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long left = 0;
        long right = (long) n * Arrays.stream(times).max().getAsInt();
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;
            
            for (int time : times) {
                sum += mid / time;
            }
            
            if (sum >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}