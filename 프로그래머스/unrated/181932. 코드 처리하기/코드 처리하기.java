class Solution {
    public String solution(String code) {
        String answer = "";
        
        // mode = 0으로 시작
        boolean mode = false;
        
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                mode = !mode;
                continue;
            }
            
            if (mode == false) {
                if (i % 2 == 0) {
                    answer += code.charAt(i);
                }
            } else{
                if (i % 2 == 1) {
                    answer += code.charAt(i);
                }   
            }
        }
        
        if (answer.length() == 0) {
            return "EMPTY";
        }
        return answer;
    }
}