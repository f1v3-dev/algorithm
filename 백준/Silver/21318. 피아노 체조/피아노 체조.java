import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Question {
    int x;
    int y;

    public Question(int x, int y) {
        this.x = x;
        this.y = y;

    }
}

public class Main {

    static int n;
    static int[] scores;
    static int q;
    static Queue<Question> queue = new LinkedList<>();
    static int[] mistakes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        scores = new int[n];
        mistakes = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.add(new Question(x, y));
        }

        System.out.println(solve());
    }

    private static String solve() {

        checkMistake();
        // i(x ≤ i < y)번 악보의 난이도가 i + 1번 악보의 난이도보다 높다면 실수를 한다
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Question question = queue.poll();
            int x = question.x;
            int y = question.y;

            // x부터 y까지 순서대로 연주할 때 몇 개의 악보에서 실수하게 될지
            int mistake = mistakes[y - 1] - mistakes[x - 1];
            sb.append(mistake).append("\n");
        }

        return sb.toString();
    }

    private static void checkMistake() {

        // 실수할 부분을 초기화
        for (int i = 0; i < n - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                mistakes[i + 1] = mistakes[i] + 1;
            } else {
                mistakes[i + 1] = mistakes[i];
            }
        }
    }
}