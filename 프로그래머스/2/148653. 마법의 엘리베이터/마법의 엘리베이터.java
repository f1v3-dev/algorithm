class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int digit = storey % 10;
            storey /= 10;
            
            if (digit == 5) {
                if (storey % 10 >= 5) {
                    answer += (10 - digit);
                    storey++;
                } else {
                    answer += digit;
                }
            } else if (digit <= 4) {
                answer += digit; 
            } else {
                answer += (10 - digit);
                storey++;
            }    
        }
        
        return answer;
    }
}