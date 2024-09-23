import java.util.*;

class Solution {
    public String solution(String s) {

        int[] result = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        return result[0] + " " + result[result.length - 1];
    }
}