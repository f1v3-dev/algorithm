import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String left = phone_book[i];
            String right = phone_book[i + 1];
            
            if (right.startsWith(left)) {
                return false;
            }
        }
        
        return true;
    }
}