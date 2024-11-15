import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {

        Arrays.sort(mats);
        
        for (int i = mats.length - 1; i >= 0; i--) {
            int mat = mats[i];
            if (isPossible(mat, park)) {
                return mat;
            }
        }

        return -1;
    }

    private static boolean isPossible(int mat, String[][] park) {

        // 공원 크기
        for (int i = 0; i <= park.length - mat; i++) {
            for (int j = 0; j <= park[0].length - mat; j++) {

                boolean flag = true;

                // 돗자리 크기
                for (int x = 0; x < mat; x++) {
                    for (int y = 0; y < mat; y++) {
                        if (!park[i + x][j + y].equals("-1")) {
                            flag = false;
                            break;
                        }
                    }

                    // 돗자리를 깔 수 없는 경우
                    if (!flag) {
                        break;
                    }
                }

                // flag = true라면, 돗자리를 깔 수 있다.
                if (flag) {
                    return true;
                }
            }
        }
        
        return false;
    }
}