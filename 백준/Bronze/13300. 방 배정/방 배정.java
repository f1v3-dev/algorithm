import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * int[성별][학년]으로 구분하여 저장
     */
    private static int[][] arr = new int[2][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int grade = Integer.parseInt(input[1]) - 1;

            arr[gender][grade]++;
        }

        calcRoom(k);
    }

    public static void calcRoom(int k) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                double ceil = Math.ceil((double) arr[i][j] / k);
                count += ceil;
            }
        }

        System.out.println(count);
    }
}