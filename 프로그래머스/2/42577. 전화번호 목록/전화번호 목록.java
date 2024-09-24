import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 접두어 -> sort
        
        Arrays.sort(phone_book);
        
        for (int i = 1; i < phone_book.length; i++) {
            String prev = phone_book[i - 1];
            String current = phone_book[i];
            
            if (current.startsWith(prev)) {
                return false;
            }
        }
        
        return true;
    }
}