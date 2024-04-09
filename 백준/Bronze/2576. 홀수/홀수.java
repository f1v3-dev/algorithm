import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            int num = sc.nextInt();

            if (num % 2 == 1) {
                list.add(num);
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = 0;
            int min = list.get(0);

            for (Integer number : list) {
                sum += number;
                min = Math.min(min, number);
            }

            System.out.println(sum);
            System.out.println(min);
        }
    }
}