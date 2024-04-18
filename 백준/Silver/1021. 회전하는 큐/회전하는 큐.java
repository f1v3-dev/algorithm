import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        input = br.readLine().split(" ");

        int count = 0;
        for (int i = 0; i < M; i++) {

            int target = Integer.parseInt(input[i]);
            int targetIndex = deque.indexOf(target);

            int pivot = deque.size() / 2;

            if (targetIndex <= pivot) {
                for (int j = 0; j < targetIndex; j++) {
                    count++;
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                }
            } else {
                for (int j = 0; j < deque.size() - targetIndex; j++) {
                    count++;
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}