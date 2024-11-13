class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int cur = 1; cur <= number; cur++) {
            
            // 1. cur 약수 개수 구하기
            int count = 0;
            
            for (int i = 1; i <= Math.sqrt(cur); i++) {
                if (cur % i == 0) {
                    if (i * i == cur) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
            
            if (count > limit) {
                count = power;
            }
            
            answer += count;
        }
        
        return answer;
    }
}