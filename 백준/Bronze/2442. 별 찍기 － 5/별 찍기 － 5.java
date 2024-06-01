import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= num; i++) {

            // left
            for (int j = 1; j <= num - i; j++) {
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