import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int r = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        // 크기가 size * size 배열
        // [r, c] 위치에 있는 값은 언제 방문하는가?
        int size = (int) Math.pow(2, N);
        find(size, r, c);

        System.out.println(count);
    }

    private static void find(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        if (r < half && c < half) {
            find(half, r, c);
        }

        else if (r < half && c >= half) {
            count += (size * size) / 4;
            find(half, r, c - half);
        }

        else if (r >= half && c < half) {
            count += ((size * size) / 4) * 2;
            find(half, r - half, c);
        }

        else {
            count += ((size * size) / 4) * 3;
            find(half, r - half, c - half);
        }
    }
}
