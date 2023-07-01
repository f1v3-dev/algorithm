import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(input[j]);
                queue.offer(val);
            }
        }

        while (N-- > 1) {
            queue.poll();
        }
        System.out.println(queue.poll());

    }
}