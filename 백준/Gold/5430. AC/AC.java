import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class AC {
    private Deque<Integer> deque;
    private boolean reversed;
    private boolean isEmpty;

    public AC(int[] arr, String commands) {
        deque = new ArrayDeque<>();
        for (int num : arr) {
            this.deque.add(num);
        }

        run(commands);
    }


    public void run(String commands) {
        String[] command = commands.split("");
        for (String cmd : command) {
            if (cmd.equals("R")) {
                reversed = !reversed;
            }
            else if (cmd.equals("D")) {
                if (deque.isEmpty()) {
                    isEmpty = true;
                    return;
                }

                if (reversed) {
                    deque.pollLast();
                }
                else {
                    deque.pollFirst();
                }
            }
        }
    }

    public int[] getResult() {
        if (isEmpty) {
            return null;
        }
        int[] result = new int[deque.size()];

        for (int i = 0; i < result.length; i++) {
            if (reversed) {
                result[i] = deque.pollLast();
            } else {
                result[i] = deque.pollFirst();
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            AC ac = new AC(arr, p);
            int[] result = ac.getResult();

            if (result == null) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                int count = 0;
                for (int num : result) {
                    if (count < result.length - 1) {
                        sb.append(num).append(",");
                    } else {
                        sb.append(num);
                    }
                    count++;
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}