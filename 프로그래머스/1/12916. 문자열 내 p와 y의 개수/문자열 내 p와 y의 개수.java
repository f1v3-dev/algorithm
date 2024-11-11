class Solution {
    boolean solution(String s) {

        s = s.toUpperCase();
        
        int pCount = 0;
        int yCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == 'P') {
                pCount++;
            } else if (ch == 'Y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}