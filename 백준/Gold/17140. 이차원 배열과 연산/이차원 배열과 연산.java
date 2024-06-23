import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static class Pair implements Comparable<Pair> {

        int number;
        int count;

        private Pair(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {

            if (this.count == o.count) {
                return this.number - o.number;
            } else if (this.count > o.count) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static int r;
    static int c;
    static int k;
    static int[][] arr = new int[101][101];
    static int rowLength = 3;
    static int columnLength = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());
    }

    private static int solve() {
        int time = 0;

        // R 연산 : 배열 A의 모든 행에 대해서 정렬을 수행 (행의 개수 >= 열의 개수)
        // C 연산 : 배열 A의 모든 열에 대해서 정렬을 수행 (행의 개수 < 열의 개수)

        // 정렬 : 등장 횟수가 커지는 순, 그러한 것이 여러가지면 수가 커지는 순으로 정렬
        while (time <= 100) {

            // 종료 조건 : arr[r][c] == k
            if (arr[r][c] == k) {
                return time;
            }

            // 연산 작업 수행
            operation();

            time++;
        }

        return -1;
    }

    private static void operation() {
        // 행의 개수 >= 열의 개수
        if (rowLength >= columnLength) {
            rowSort();
        } else {
            // 열의 개수 > 행의 개수
            columnSort();
        }
    }

    private static void rowSort() {
        int maxColumnLength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= rowLength; i++) {
            for (int j = 1; j <= columnLength; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }

                map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
            }

            List<Pair> list = map.keySet().stream()
                    .map(key -> new Pair(key, map.get(key)))
                    .sorted()
                    .collect(Collectors.toList());

            // 정렬된 결과를 다시 배열에 넣어준다.
            for (int j = 1; j <= list.size(); j++) {

                if (j > 50) {
                    break;
                }

                Pair pair = list.get(j - 1);
                arr[i][j * 2 - 1] = pair.number;
                arr[i][j * 2] = pair.count;
            }

            for (int j = list.size() * 2 + 1; j <= 100; j++) {
                arr[i][j] = 0;
            }

            // 배열의 길이를 조정해준다.
            maxColumnLength = Math.min(101, Math.max(maxColumnLength, list.size() * 2));

            map.clear();
        }

        columnLength = maxColumnLength;
    }

    private static void columnSort() {
        int maxRowLength = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= columnLength; i++) {
            for (int j = 1; j <= rowLength; j++) {
                if (arr[j][i] == 0) {
                    continue;
                }

                map.put(arr[j][i], map.getOrDefault(arr[j][i], 0) + 1);
            }

            List<Pair> list = map.keySet().stream()
                    .map(key -> new Pair(key, map.get(key)))
                    .sorted()
                    .collect(Collectors.toList());

            // 정렬된 결과를 다시 배열에 넣어준다.
            for (int j = 1; j <= list.size(); j++) {

                if (j > 50) {
                    break;
                }

                Pair pair = list.get(j - 1);
                arr[j * 2 - 1][i] = pair.number;
                arr[j * 2][i] = pair.count;
            }

            for (int j = list.size() * 2 + 1; j <= 100; j++) {
                arr[j][i] = 0;
            }

            // 배열의 길이를 조정해준다.
            maxRowLength = Math.min(101, Math.max(maxRowLength, list.size() * 2));

            map.clear();
        }

        rowLength = maxRowLength;
    }
}