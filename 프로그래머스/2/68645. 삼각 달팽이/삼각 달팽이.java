class Solution {
    public int[] solution(int n) {
        
        int[][] arr = new int[n][n];
        
        // 아래, 오른쪽, 위(-1, -1) 반복
        // 시작은 0,0에서 아래로 
        int x = -1;
        int y = 0;
        
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                
                arr[x][y] = num++;
            }
        }
        
        
        // 2차원 배열을 1차원 배열로 옮긴다.
        int[] answer = new int[num - 1];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i][j] == 0) {
                    break;
                }
                
                answer[index++] = arr[i][j];
            }
        }
        
        return answer;
    }
}