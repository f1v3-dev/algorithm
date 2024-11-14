import java.util.*;

class Solution {
    public int solution(String dartResult) {
        
        int[] score = new int[3];
        
        int index = 0;
        
        // 점수 | 보너스 | [옵션]
        
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            if (Character.isDigit(ch)) {
                
                // 10 처리
                if (ch == '1' && dartResult.charAt(i + 1) == '0') {
                    score[index] = 10;
                    i++;
                } else {
                    score[index] = ch - '0';
                }
            } else if (ch == 'S' || ch == 'D' || ch == 'T') {
                // D, T에 대해서만 처리하면 됨
                if (ch == 'D') {
                    score[index] = (int) Math.pow(score[index], 2);
                } else if (ch == 'T') {
                    score[index] = (int) Math.pow(score[index], 3);
                }
                
                // index 증가
                index++;
            } else {
                // 옵션인 것을 감안해야 함.
                if (ch == '*') {
                    if (index == 1) {
                        score[index - 1] *= 2;
                    } else {
                        score[index - 2] *= 2;
                        score[index - 1] *= 2;
                    }
                } else if (ch == '#') {
                    score[index - 1] *= -1;
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += score[i];
        }
    
        return answer;
    }
}