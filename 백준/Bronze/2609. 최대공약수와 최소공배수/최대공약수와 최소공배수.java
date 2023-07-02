import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int minVal = Math.min(N, M);
        int maxVal = Math.max(N, M);


        // 최대공약수
        int div = 0;
        for (int i = 1; i <= minVal; i++){
            if (minVal % i == 0) {
                if (maxVal % i == 0){
                    div = Math.max(i, div);
                }
            }
        }
        sb.append(div).append("\n");

        // 최소공약수
        int count = 1;
        while (true) {
            int val = maxVal * count;
            if (val % minVal == 0) {
                sb.append(val);
                break;
            }
            count++;
        }

        System.out.println(sb);
    }
}