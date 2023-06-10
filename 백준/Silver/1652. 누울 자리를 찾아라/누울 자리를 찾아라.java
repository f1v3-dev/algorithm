import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] map = new char[N+1][N+1];

        for (int i = 0; i < N; i++){
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
            // 맨 오른쪽과 아래쪽을 벽으로 가정
            map[i][N] = 'X';
            map[N][i] = 'X';
        }
        int x = 0, y = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (map[i][j] == '.' && map[i][j + 1] == '.' && map[i][j + 2] == 'X') x++;
                if (map[j][i] == '.' && map[j + 1][i] == '.' && map[j + 2][i] == 'X') y++;
            }
        }

        System.out.println(x + " " + y);


    }
}