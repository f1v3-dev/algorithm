import java.util.*;

class Word {
    String word;
    int count;
    
    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        
        queue.offer(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word current = queue.poll();
            String curWord = current.word;
            int curCount = current.count;
            
            if (curWord.equals(target)) {
                return curCount;
            }
            
            // curWord에서 한 글자만 다른 글자 찾기
            for (int i = 0; i < words.length; i++) {
                
                if (!visited[i] && isOneDifferent(curWord, words[i])) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], curCount + 1));
                }
            }
        }
        
        
        return 0;
    }
    
    private boolean isOneDifferent(String w1, String w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        
        int diffCount = 0;
        
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diffCount++;
                
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        
        return diffCount == 1;
    }
}