import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        dfs(0, arr);
        System.out.println(max);
    }

    private static void dfs(int count, int[][] copiedArray) {
        if (count == 5) {
            updateMax(copiedArray);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] temp = new int[n][n];
            copyArray(copiedArray, temp);
            move(temp, i);
            dfs(count + 1, temp);
        }
    }

    private static void updateMax(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                max = Math.max(max, value);
            }
        }
    }

    private static void copyArray(int[][] source, int[][] destination) {
        for (int i = 0; i < n; i++) {
            System.arraycopy(source[i], 0, destination[i], 0, n);
        }
    }

    private static void move(int[][] temp, int direction) {
        boolean[][] merged = new boolean[n][n];
        if (direction == 0) {
            moveRight(temp, merged);
        } else if (direction == 1) {
            moveLeft(temp, merged);
        } else if (direction == 2) {
            moveUp(temp, merged);
        } else if (direction == 3) {
            moveDown(temp, merged);
        }
    }

    private static void moveRight(int[][] temp, boolean[][] merged) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (temp[i][j] != 0) {
                    int k = j;
                    while (k + 1 < n && temp[i][k + 1] == 0) {
                        temp[i][k + 1] = temp[i][k];
                        temp[i][k] = 0;
                        k++;
                    }
                    if (k + 1 < n && temp[i][k + 1] == temp[i][k] && !merged[i][k + 1]) {
                        temp[i][k + 1] *= 2;
                        temp[i][k] = 0;
                        merged[i][k + 1] = true;
                    }
                }
            }
        }
    }

    private static void moveLeft(int[][] temp, boolean[][] merged) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] != 0) {
                    int k = j;
                    while (k - 1 >= 0 && temp[i][k - 1] == 0) {
                        temp[i][k - 1] = temp[i][k];
                        temp[i][k] = 0;
                        k--;
                    }
                    if (k - 1 >= 0 && temp[i][k - 1] == temp[i][k] && !merged[i][k - 1]) {
                        temp[i][k - 1] *= 2;
                        temp[i][k] = 0;
                        merged[i][k - 1] = true;
                    }
                }
            }
        }
    }

    private static void moveUp(int[][] temp, boolean[][] merged) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[j][i] != 0) {
                    int k = j;
                    while (k - 1 >= 0 && temp[k - 1][i] == 0) {
                        temp[k - 1][i] = temp[k][i];
                        temp[k][i] = 0;
                        k--;
                    }
                    if (k - 1 >= 0 && temp[k - 1][i] == temp[k][i] && !merged[k - 1][i]) {
                        temp[k - 1][i] *= 2;
                        temp[k][i] = 0;
                        merged[k - 1][i] = true;
                    }
                }
            }
        }
    }

    private static void moveDown(int[][] temp, boolean[][] merged) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (temp[j][i] != 0) {
                    int k = j;
                    while (k + 1 < n && temp[k + 1][i] == 0) {
                        temp[k + 1][i] = temp[k][i];
                        temp[k][i] = 0;
                        k++;
                    }
                    if (k + 1 < n && temp[k + 1][i] == temp[k][i] && !merged[k + 1][i]) {
                        temp[k + 1][i] *= 2;
                        temp[k][i] = 0;
                        merged[k + 1][i] = true;
                    }
                }
            }
        }
    }
}
