import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        int len = nums.length / 2;
        
        for (int num : nums) {
            set.add(num);
        }
        
        return set.size() > len ? len : set.size();
    }
}