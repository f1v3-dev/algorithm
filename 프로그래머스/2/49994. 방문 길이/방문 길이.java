import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {

        int answer = 0;

        Set<String> set = new HashSet<>();

        // 시작점 : (0, 0) 인데 5, 5
        int x = 5;
        int y = 5;

        for (char ch : dirs.toCharArray()) {

            // x, y -> nx, ny로 이동
            int nx = x;
            int ny = y;

            switch (ch) {
                case 'U' -> nx -= 1;
                case 'D' -> nx += 1;
                case 'R' -> ny += 1;
                case 'L' -> ny -= 1;
            }

            if (nx >= 0 && nx <= 10 && ny >= 0 && ny <= 10) {

                // 양방향 처리
                String path = Math.min(x, nx) + "," + Math.min(y, ny) + " " +
                        Math.max(x, nx) + "," + Math.max(y, ny);

                if (!set.contains(path)) {
                    set.add(path);
                    answer++;
                }

                x = nx;
                y = ny;
            }
        }


        return answer;
    }
}
