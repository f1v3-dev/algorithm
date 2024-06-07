import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int h;
    static int w;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        h = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);

        int[] blocks = new int[w];
        input = br.readLine().split(" ");
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            // 1. 왼쪽에서 가장 큰 값 가져오기
            for (int j = 0; j < i; j++) {
                left = Math.max(left, blocks[j]);
            }

            // 2. 오른쪽에서 가장 큰 기둥 가져오기
            for (int j = i + 1; j < w; j++) {
                right = Math.max(right, blocks[j]);
            }

            // 3. 사이에 있는 공간에서 왼쪽부터
            if (left >= blocks[i] && right >= blocks[i]) {
                result += Math.min(left, right) - blocks[i];
            }
        }

        System.out.println(result);
    }
}