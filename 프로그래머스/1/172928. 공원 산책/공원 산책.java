class Solution {
    public int[] solution(String[] park, String[] routes) {

        int prevX = 0;
        int prevY = 0;

        boolean[][] map = new boolean[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = (park[i].charAt(j) == 'O' || park[i].charAt(j) == 'S');

                if (park[i].charAt(j) == 'S') {
                    prevX = i;
                    prevY = j;
                }
            }
        }

        for (String route : routes) {
            String[] split = route.split(" ");
            String direction = split[0];
            int distance = Integer.parseInt(split[1]);

            int nextX = prevX;
            int nextY = prevY;

            for (int i = 0; i < distance; i++) {
                if ("E".equals(direction)) {
                    nextY++;  // 열 증가
                }

                if ("W".equals(direction)) {
                    nextY--;  // 열 감소
                }

                if ("N".equals(direction)) {
                    nextX--;  // 행 감소
                }

                if ("S".equals(direction)) {
                    nextX++;  // 행 증가
                }

                if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length) {
                    if (!map[nextX][nextY]) {
                        break;
                    }

                    if (i == distance - 1) {
                        prevX = nextX;
                        prevY = nextY;
                    }
                }
            }
        }

        return new int[]{prevX, prevY};
    }
}