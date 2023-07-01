import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                if (absA == absB) {
                    return Integer.compare(a, b);
                }
                return Integer.compare(absA, absB);
            }
        });

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                queue.offer(num);
            }

            else {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(queue.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}