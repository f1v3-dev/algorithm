import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            Long N = sc.nextLong();
            Long M = sc.nextLong();

            Long minVal = (long) Math.min(N, M);
            Long maxVal = (long) Math.max(N, M);

            int count = 1;
            while(true) {
                Long val = maxVal * count;
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