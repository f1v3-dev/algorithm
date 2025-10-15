import java.util.*;

class Solution {
    private int count = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        dfs(1, n, new HashSet<>(), q, ans);
        return count;
    }
    
    private void dfs(int start, int n, Set<Integer> current, int[][] q, int[] ans) {
        
        
        if (!isValid(current, q, ans, start, n)) {
            return;
        }
        
        if (current.size() == 5) {
            count++;
            return;
        }
        
        for (int curNum = start; curNum <= n; curNum++) {
            current.add(curNum);
            dfs(curNum + 1, n, current, q, ans);
            current.remove(curNum);
        }
    }
    
    private boolean isValid(Set<Integer> current, int[][] q, int[] ans, int start, int n) {
        
        int remaining = 5 - current.size(); // 남은 숫자 개수
        int available = n - start + 1; // 선택 가능한 숫자 개수
        
        // 선택 가능한 숫자가 부족한 경우
        if (available < remaining) {
            return false;
        }
        
        for (int i = 0; i < q.length; i++) {
            int matches = 0;
            int possible = 0;
            
            for (int num : q[i]) {
                if (current.contains(num)) {
                    matches++;
                } else if (num >= start && num <= n) {
                    possible++;
                }
            }
            
            if (matches > ans[i] || matches + Math.min(remaining, possible) < ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}