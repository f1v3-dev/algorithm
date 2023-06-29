class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        
        int minRow, minColumn;
        int maxRow, maxColumn;
        
        minRow = minColumn = 9999;
        maxRow = maxColumn = -9999;
        
        int row = wallpaper.length;
        int column = wallpaper[0].length();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++){
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minColumn = Math.min(minColumn, j);
                    
                    // 마지막 파일의 위치에서 오른쪽 아래에 드래그를 해야하기 때문에
                    // Row와 Column에 각각 + 1
                    maxRow = Math.max(maxRow, i + 1);
                    maxColumn = Math.max(maxColumn, j + 1);
                }
            }
        }
        answer = new int[]{minRow, minColumn, maxRow, maxColumn};
        return answer;
    }
}