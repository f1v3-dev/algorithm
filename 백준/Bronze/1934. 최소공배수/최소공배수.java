import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int minVal = Math.min(N, M);
            int maxVal = Math.max(N, M);

            // 최소공약수
            int count = 1;
            while (true) {
                int val = maxVal * count;
                if (val % minVal == 0) {
                    sb.append(val).append("\n");
                    break;
                }
                count++;
            }
        }

        System.out.println(sb);
    }
}