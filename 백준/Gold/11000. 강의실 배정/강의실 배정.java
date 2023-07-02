import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];

        for (int i = 0; i < num; i++) {
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 정렬한 배열 중 첫 번째 종료시간을 offer
        queue.offer(arr[0][1]);

        for (int i = 1; i < num; i++) {
            // queue.peek()[종료시간]이 다음 시작시간보다 작거나 같을 경우
            // 즉, 다음 수업을 할 수 있는 경우
            if (queue.peek() <= arr[i][0]) {
                queue.poll();
            }

            // 각각의 수업 종료시간을 offer
            queue.offer(arr[i][1]);
        }

        System.out.println(queue.size());
    }
}
