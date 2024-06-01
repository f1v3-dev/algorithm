import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        // 2개의 for문 작성

        // 1. 별의 수가 증가
        for (int i = 1; i <= n; i++) {

            // left
            for (int j = 1; j <= n - i; j++) {
                sb.append(" ");
            }

            // right
            for (int j = 1; j <= 2 * i - 1; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        // 2. 별의 수가 감소 (이 때 첫 줄은 무시)
        for (int i = n - 1; i > 0; i--) {

            // left
            for (int j = 1; j <= n - i; j++) {
                sb.append(" ");
            }

            // right
            for (int j = 1; j <= 2 * i - 1; j++) {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}