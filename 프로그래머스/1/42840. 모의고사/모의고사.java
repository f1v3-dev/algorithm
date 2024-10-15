import java.util.*;

class Solution {
    
    static int[] a = {1, 2, 3, 4, 5};
    static int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        int[] count = new int[3];
        
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            if (a[i % a.length] == answer) {
                count[0]++;
            }
            
            if (b[i % b.length] == answer) {
                count[1]++;
            }
            
            if (c[i % c.length] == answer) {
                count[2]++;
            }
        }
        
        int max = Math.max(count[0], Math.max(count[1], count[2]));
            
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                result.add(i + 1);
            }
        }
        
        return result.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}