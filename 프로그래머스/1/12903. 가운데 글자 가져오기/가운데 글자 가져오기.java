class Solution {
    public String solution(String s) {
        
        int len = s.length();
        int index = len / 2;
        
        if (len % 2 == 1) {
            return s.substring(index, index + 1);
        }

        return s.substring(index - 1, index + 1);
    }
}