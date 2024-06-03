class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[][] board, int h, int w) {
        
        String color = board[h][w];
        
        int size = board.length;
        int count = 0;
        
        // 상하좌우
        for (int i = 0; i < 4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];
            
            if (x >= 0 && y >= 0 && x < size && y < size) {
                if (color.equals(board[x][y])) {
                    count++;
                }
            }
            
        }
        
        return count;
        
    }
}