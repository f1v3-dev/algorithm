import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] line = br.readLine().split(" ");

            long x = Long.parseLong(line[0]);
            long y = Long.parseLong(line[1]);
            long z = Long.parseLong(line[2]);

            if (x == 0 && y == 0 && z == 0) {
                break;
            }

            boolean isTriangle = Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2) ||
                                    Math.pow(y, 2) + Math.pow(z, 2) == Math.pow(x, 2) ||
                                    Math.pow(z, 2) + Math.pow(x, 2) == Math.pow(y, 2);

            if (isTriangle) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}