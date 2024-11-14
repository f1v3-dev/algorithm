class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] leftPosition = {3, 0};
        int[] rightPosition = {3, 2};
        
        for (int num : numbers) {
            
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPosition = new int[]{num / 3, 0};
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPosition = new int[]{num / 4, 2};
            } else {
                
                // 가운데
                int[] target;
                if (num == 0) {
                    target = new int[]{3, 1};
                } else {
                    target = new int[]{num / 4, 1};
                }
                
                int leftDistance = 
                    Math.abs(leftPosition[0] - target[0]) +
                    Math.abs(leftPosition[1] - target[1]);
                
                int rightDistance = 
                    Math.abs(rightPosition[0] - target[0]) + 
                    Math.abs(rightPosition[1] - target[1]);
                
                if (leftDistance == rightDistance) {
                    if ("left".equals(hand)) {
                        leftPosition = target;
                        sb.append("L");
                    } else {
                        rightPosition = target;
                        sb.append("R");
                    }
                } else if (leftDistance < rightDistance) {
                    leftPosition = target;
                    sb.append("L");
                } else {
                    rightPosition = target;
                    sb.append("R");
                }
            }
        }
        
        return sb.toString();
    }
}