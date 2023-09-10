import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;

    private static int[] result;
    private static int size;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());

            if (size == 0) {
                break;
            }

            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            backTracking(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void backTracking(int depth, int start) {
        if (depth == 6) {
            for (int num : result) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        else {
            for (int i = start; i < size; i++) {
                result[depth] = arr[i];
                backTracking(depth + 1, i + 1);
            }
        }
    }
}