import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 소수이면서 팰린드롬인 수(뒤집은 수가 같은 수)
        // 소수 찾기 : 에라토스테네스의 체
        // 팰린드롬 확인 : 정수 -> 문자열로 변경 후 숫자 비교

        // 에라토스테네스의 체를 활용하여 소수를 따로 초기화
        boolean [] isPrime = new boolean[1003002];

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < isPrime.length; i++){
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j+= i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = N; i < isPrime.length; i++) {
            if (isPrime[i]) {
                String num = Integer.toString(i);
                StringBuffer sb = new StringBuffer(num);
                num = sb.reverse().toString();
                int revNum = Integer.parseInt(num);
                if (i == revNum) {
                    System.out.println(revNum);
                    break;
                }

            }
        }
    }
}