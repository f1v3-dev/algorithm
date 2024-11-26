class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            
            char[][] map = new char[5][5];
            for (int j = 0; j < 5; j++) {
                map[j] = place[j].toCharArray();
            }
            
            answer[i] = isPossible(map) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean isPossible(char[][] map) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] != 'P') {
                    continue;
                }
                
                // 오른쪽 확인
                if (j + 1 < 5 && map[i][j + 1] == 'P') {
                    return false;
                }
                
                // 두 칸 오른쪽 확인
                if (j + 2 < 5 && map[i][j + 2] == 'P' && map[i][j + 1] != 'X') {
                    return false;
                }
                
                // 아래쪽 확인
                if (i + 1 < 5 && map[i + 1][j] == 'P') {
                    return false;
                }
                
                // 두 칸 아래쪽 확인
                if (i + 2 < 5 && map[i + 2][j] == 'P' && map[i + 1][j] != 'X') {
                    return false;
                }
                
                // 오른쪽 아래 대각선 확인
                if (i + 1 < 5 && j + 1 < 5 && map[i + 1][j + 1] == 'P' &&
                    (map[i + 1][j] != 'X' || map[i][j + 1] != 'X')) {
                    return false;
                }
                
                // 왼쪽 아래 대각선 확인
                if (i + 1 < 5 && j - 1 >= 0 && map[i + 1][j - 1] == 'P' &&
                    (map[i + 1][j] != 'X' || map[i][j - 1] != 'X')) {
                    return false;
                }
            }
        }
        return true;
    }
}