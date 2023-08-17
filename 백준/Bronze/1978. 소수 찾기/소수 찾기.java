import java.util.Scanner;

public class Main {

    public static boolean decimal(int num) {
        if (num < 2)
            return false;

        else if (num == 2) {
            return true;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int count = 0;
        for (int i = 0; i < num; i++) {
             int val = sc.nextInt();
             if (decimal(val))
                 count++;
        }
        System.out.println(count);
    }
}