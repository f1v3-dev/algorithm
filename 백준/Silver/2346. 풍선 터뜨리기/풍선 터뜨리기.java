import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < testCase; i++){
            int num = Integer.parseInt(str[i]);
            deque.add(new int[] { i + 1, num });
        }

        while(deque.size() > 1) {
            int [] frontVal = deque.pollFirst();
            sb.append(frontVal[0]).append(" ");

            int index = frontVal[1];
            if (index > 0) {
                for (int i = 0; i < index - 1; i++){
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(index); i++){
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        sb.append(deque.poll()[0]);
        System.out.println(sb.toString());

    }
}