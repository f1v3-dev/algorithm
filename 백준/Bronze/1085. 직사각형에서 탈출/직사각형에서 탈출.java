import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");

        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int w = Integer.parseInt(split[2]);
        int h = Integer.parseInt(split[3]);

        // 직사각형 경계선까지 가는 거리의 최솟값

        int minX = Math.min(x, w - x);
        int minY = Math.min(y, h - y);

        int min = Math.min(minX, minY);

        System.out.println(min);
    }
}