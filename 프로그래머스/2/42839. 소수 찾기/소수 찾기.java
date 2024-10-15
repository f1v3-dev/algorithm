import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited = new boolean[7];
    
    public int solution(String numbers) {
        
        dfs(numbers, "", 0);
        
        int answer = 0;
        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(String num, String str, int depth) {
        
        if (depth > num.length()) {
            return;
        }
        
        for (int i = 0; i < num.length(); i++) {
            if (!visited[i]) {
                char ch = num.charAt(i);
                visited[i] = true;
                set.add(Integer.parseInt(str + ch));
                dfs(num, str + ch, depth + 1);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}