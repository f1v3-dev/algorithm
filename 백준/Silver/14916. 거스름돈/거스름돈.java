import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0;

        while (num > 0) {
            if (num % 5 == 0){
                num -= 5;
                count++;
            }
            else {
                num -= 2;
                count++;
            }
        }

        if (num < 0){
            System.out.println(-1);
        }
        else {
            System.out.println(count);
        }

    }
}