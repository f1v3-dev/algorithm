class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int givenLen = deliveries.length;
        int takenLen = pickups.length;
        
        while (givenLen > 0 || takenLen > 0) {
            
            while (givenLen > 0 && deliveries[givenLen - 1] == 0) {
                givenLen--;
            }
            
            while (takenLen > 0 && pickups[takenLen - 1] == 0) {
                takenLen--;
            }
            
            // 왕복이니 * 2
            answer += Math.max(givenLen, takenLen) * 2;
            givenLen = update(deliveries, givenLen, cap);
            takenLen = update(pickups, takenLen, cap);
        }
        
        return answer;
    }
    
    private static int update(int[] arr, int len, int cap) {
        
        // cap = 현재 들고있는 상자
        while (len > 0) {
            
            // 더이상 트럭에 넣을 수 없는 경우
            if (cap < arr[len - 1]) {
                arr[len - 1] -= cap;
                break;
            }
            
            
            cap -= arr[len - 1];
            len--;
        }
        
        return len;
    }
}