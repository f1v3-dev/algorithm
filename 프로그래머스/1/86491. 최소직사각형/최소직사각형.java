class Solution {
    public int solution(int[][] sizes) {
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        
        for (int[] size : sizes) {
            int currentMax = Math.max(size[0], size[1]);
            int currentMin = Math.min(size[0], size[1]);
            
            max = Math.max(max, currentMax);
            min = Math.max(min, currentMin);
        }
        
        return max * min;

    }
}