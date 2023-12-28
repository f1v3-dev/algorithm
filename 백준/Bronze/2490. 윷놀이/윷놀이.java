import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 도(A) 개(B) 걸(C) 윷(D) 모(E)
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String input = sc.nextLine();

            // 배 : 0, 등 : 1
            // 도(배 한 개, 등 세 개), 개(배 두 개, 등 두 개), 걸(배 세 개, 등 한 개), 윷(배 네 개), 모(등 네 개)
            input = input.replaceAll(" ", "");

            int zero = 0;
            int one = 0;
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == '0') {
                    zero++;
                } else if (ch == '1') {
                    one++;
                }
            }

            if (zero == 4 && one == 0) {
                System.out.println("D");
            } else if (zero == 0 && one == 4) {
                System.out.println("E");
            } else if (zero == 1 && one == 3) {
                System.out.println("A");
            } else if (zero == 2 && one == 2) {
                System.out.println("B");
            } else if (zero == 3 && one == 1) {
                System.out.println("C");
            }
        }
    }
}