import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            String[] input = br.readLine().split(" ");
            for (String str : input) {
                queue.add(Integer.parseInt(str));
            }

            // 3번째로 큰 값 출력
            for (int j = 0; j < 2; j++) {
                queue.poll();
            }
            System.out.println(queue.poll());
        }
    }
}