import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[][] board;
    static int n;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 사탕의 색이 다른 인접한 두 칸을 고르고 두 칸을 교환
        // 같은 색으로 이루어져있는 가장 긴 연속 부분(행 / 열)을 고르고 그 길이를 갱신

        // 1. 행에서 교환하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                check();
                swap(i, j, i, j + 1);
            }
        }

        // 2. 열에서 교환하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(j, i, j + 1, i);
                check();
                swap(j, i, j + 1, i);
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    static void check() {
        for (int i = 0; i < n; i++) {
            int count = 1;

            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }

            max = Math.max(max, count);
        }

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }

            max = Math.max(max, count);
        }
    }
}