import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long input = sc.nextLong();
        int count = 1;
        while (input > 0) {
            input = input - count;
            if (input < 0) {
                break;
            }
            count++;
        }
        System.out.println(count - 1);

    }
}