class Solution {
    public int jump(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return 0;
        }

        int current = 0;
        int end = 0;
        int jumps = 0;

        for (int i = 0; i < len - 1; i++) {
            current = Math.max(current, i + nums[i]);

            // 최대 거리 도달 가능?
            if (i == end) {
                jumps++;
                end = current;
            }
        }

        return jumps;
    }
}