import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 물품 수
        int K = sc.nextInt(); // 최대 무게

        int[] w = new int[N+1]; // 각 물품의 무게
        int[] v = new int[N+1]; // 각 물품의 가치

        for (int i = 1; i <= N; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }


        int [][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= K; j++){
                dp[i][j] = dp[i-1][j];
                if(w[i] <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        System.out.print(dp[N][K]);



    }
}