import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n, k;
    static int[] arr;
    static List<Integer> plugs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        arr = new int[k];
        input = br.readLine().split(" ");

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solve());
    }

    private static int solve() {
        int changeCount = 0;

        for (int i = 0; i < k; i++) {
            int curItem = arr[i];

            if (plugs.contains(curItem)) {
                continue;
            }

            if (plugs.size() < n) {
                plugs.add(curItem);
                continue;
            }

            int index = -1;
            int maxIndex = -1;

            for (int j = 0; j < n; j++) {
                int nextIndex = getLastIndex(i, plugs.get(j));

                if (nextIndex > maxIndex) {
                    maxIndex = nextIndex;
                    index = j;
                }
            }

            plugs.set(index, curItem);
            changeCount++;
        }

        return changeCount;
    }

    private static int getLastIndex(int index, int item) {
        for (int i = index + 1; i < k; i++) {
            if (arr[i] == item) {
                return i;
            }
        }

        return k;
    }
}