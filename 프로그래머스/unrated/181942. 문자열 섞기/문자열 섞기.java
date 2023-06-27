class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int size = str1.length() + str2.length();
        
        for (int i = 0; i < size; i++) {
            if (i < str1.length()) {
                answer += str1.charAt(i);
            }
            if (i < str2.length()) {
                answer += str2.charAt(i);
            }
        }
        return answer;
    }
}