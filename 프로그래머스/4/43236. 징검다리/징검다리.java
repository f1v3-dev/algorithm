import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        // new rock array
        int[] arr = new int[rocks.length + 1];
        arr[0] = rocks[0];
        arr[arr.length - 1] = distance - rocks[rocks.length - 1];
        
        for (int i = 1; i < rocks.length; i++) {
            arr[i] = rocks[i] - rocks[i - 1];
        }
        
        int left = 0;
        int right = distance;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int removedRocks = 0;
            int current = 0;
            
            for (int rock : arr) {
                current += rock;
                
                if (current < mid) {
                    removedRocks++;
                } else {
                    current = 0;
                }
            }
            
            if (removedRocks <= n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}