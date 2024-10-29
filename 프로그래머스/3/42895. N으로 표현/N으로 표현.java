import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            list.add(new HashSet<>());
        }
        
        // 첫 번째는 N만 넣을 수 있음.
        list.get(1).add(N);
        
        
        // 두 번째부터는 N과 사칙연산
        for (int i = 2; i < 9; i++) {
            
            Set<Integer> cur = list.get(i);
            
            String str = String.valueOf(N);
            str = str.repeat(i);
            cur.add(Integer.parseInt(str));
            
            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = list.get(j);
                Set<Integer> postSet = list.get(i - j);
                
                for (Integer pre : preSet) {
                    for (Integer post : postSet) {
                        cur.add(pre + post);
                        cur.add(pre - post);
                        cur.add(pre * post);
                        
                        if (pre != 0 && post != 0) {
                            cur.add(pre / post);
                        }
                    }
                }
            }
            
            if (cur.contains(number)) {
                return i;
            }
        }
        
        
        return -1;
    }
}