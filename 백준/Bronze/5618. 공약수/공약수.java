import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        int [] arr = new int[num];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(str[i]);
        }


        Arrays.sort(arr);
        int minVal = arr[0];

        for (int i = 1; i <= minVal; i++){
            int count = 0;

            for (int j = 0; j < num; j++) {
                if (arr[j] % i == 0) {
                    count++;
                }
            }

            if (num == count) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}