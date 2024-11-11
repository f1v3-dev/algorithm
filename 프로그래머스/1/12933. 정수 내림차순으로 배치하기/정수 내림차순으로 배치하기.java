import java.util.*;

class Solution {
    public long solution(long n) {

        String[] str = String.valueOf(n).split("");
        Arrays.sort(str);
        
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]);
        }

        return Long.parseLong(sb.toString());
    }
}