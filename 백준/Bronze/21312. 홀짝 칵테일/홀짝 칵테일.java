import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        boolean check = false;
        int oddResult = 1;
        int evenResult = 1;
        for (int i = 0; i < 3; i++){
            int num = Integer.parseInt(str[i]);
            // 입력한 값이 홀수이면
            if (num % 2 == 1) {
                check = true;
                oddResult *= num;
            }
            evenResult *= num;
        }

        if (check) {
            System.out.println(oddResult);
        } else System.out.println(evenResult);
    }
}