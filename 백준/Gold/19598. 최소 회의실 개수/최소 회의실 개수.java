import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }

            return this.start - o.start;
        }
    }

    static int n;
    static Time[] times;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        times = new Time[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            times[i] = new Time(start, end);
        }

        solve();
    }

    private static void solve() {

        // 시작 시간을 기준으로 정렬
        Arrays.sort(times);

        Queue<Time> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));

        int roomCount = 1;

        for (int i = 0; i < n; i++) {

            // 순차적으로 하나씩 queue.offer
            Time time = times[i];
            queue.offer(time);

            // 새로운 회의가 시작되기 전 이전에 진행하던 회의가 끝나 방을 뺀 경우
            while (time.start >= queue.peek().end) {
                queue.poll();
            }

            roomCount = Math.max(roomCount, queue.size());
        }


        System.out.println(roomCount);
    }
}