class Solution {
    
    static String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public String solution(int a, int b) {
        
        int day = 0;
        
        for (int i = 0; i < a; i++) {
            day += months[i];
        }
        
        day += b;
        
        // 금요일 시작
        return days[(day + 4) % 7];
    }
}