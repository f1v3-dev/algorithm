import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int studentCount = Integer.parseInt(st.nextToken());
            long maxCandies = Long.parseLong(st.nextToken());

            long[] scores = new long[studentCount];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < studentCount; i++) {
                scores[i] = Long.parseLong(st.nextToken());
            }


            long result = getResult(scores, maxCandies);
            bw.write(result + "\n");
            bw.flush();
        }

    }

    private static long getResult(long[] scores, long maxCandies) {

        // binary search
        Arrays.sort(scores);

        long left = 0;
        long right = scores[scores.length - 1];
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(scores, mid, maxCandies)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean isPossible(long[] scores, long current, long maxCandies) {
        long requiredCandies = 0;

        for (long score : scores) {
            if (score > current) {
                requiredCandies += (score - current);

                if (requiredCandies > maxCandies) {
                    return false;
                }
            }
        }

        return requiredCandies <= maxCandies;
    }
}

