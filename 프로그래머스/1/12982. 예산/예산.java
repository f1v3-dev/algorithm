import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {        
        
        Arrays.sort(d);
        
        int answer = 0;
        int sum = 0;
        
        for (int num : d) {
            sum += num;
            
            if (budget < sum) {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}