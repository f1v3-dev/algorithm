import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
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
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(max, copiedArray[i][j]);
                }
            }

            return;
        }


        for (int i = 0; i < 4; i++) {
            int[][] temp = new int[n][n];
            for (int j = 0; j < n; j++) {
                System.arraycopy(copiedArray[j], 0, temp[j], 0, n);
            }

            // 1. 상하좌우로 이동
            // 2. 이동하는 방향으로 같은 숫자가 존재할 경우 합치기
            // 3. 만약 변경사항이 없을 경우 -> 다음 방향으로 이동
            // 4. 변경사항이 존재할 경우 -> 다음 dfs 호출
            // 5. dfs 호출 후 원래 배열로 복귀

            move(temp, i);
            dfs(count + 1, temp);
        }
    }


    private static void move(int[][] temp, int direction) {


        // 1. 이동 방향에 0이 존재할 경우 해당 방향의 값들을 끝까지 이동시키기
        // 2. 이동 방향에 같은 숫자가 존재할 경우 합치기
        // 3. 합친 후 0이 존재할 경우 해당 방향의 값들을 끝까지 이동시키기

        switch (direction) {
            // right (y값 증가)
            case 0:

                // 2번
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (temp[i][j] != 0) {
                            for (int k = j - 1; k >= 0; k--) {
                                if (temp[i][k] == temp[i][j]) {
                                    temp[i][j] *= 2;
                                    temp[i][k] = 0;
                                    break;
                                } else if (temp[i][k] != 0) {
                                    break;
                                }
                            }
                        }
                    }
                }

                // 3번
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (temp[i][j] == 0) {
                            for (int k = j - 1; k >= 0; k--) {
                                if (temp[i][k] != 0) {
                                    temp[i][j] = temp[i][k];
                                    temp[i][k] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;

            // left (y값 감소)
            case 1:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (temp[i][j] == 0) {
                            for (int k = j + 1; k < n; k++) {
                                if (temp[i][k] != 0) {
                                    temp[i][j] = temp[i][k];
                                    temp[i][k] = 0;
                                    break;
                                }

                            }
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (temp[i][j] != 0) {
                            for (int k = j + 1; k < n; k++) {
                                if (temp[i][k] == temp[i][j]) {
                                    temp[i][j] *= 2;
                                    temp[i][k] = 0;
                                    break;
                                } else if (temp[i][k] != 0) {
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (temp[i][j] == 0) {
                            for (int k = j + 1; k < n; k++) {
                                if (temp[i][k] != 0) {
                                    temp[i][j] = temp[i][k];
                                    temp[i][k] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;

            // up (x값 감소)
            case 2:
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (temp[j][i] == 0) {
                            for (int k = j + 1; k < n; k++) {
                                if (temp[k][i] != 0) {
                                    temp[j][i] = temp[k][i];
                                    temp[k][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (temp[j][i] != 0) {
                            for (int k = j + 1; k < n; k++) {
                                if (temp[k][i] == temp[j][i]) {
                                    temp[j][i] *= 2;
                                    temp[k][i] = 0;
                                    break;
                                } else if (temp[k][i] != 0) {
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (temp[j][i] == 0) {
                            for (int k = j + 1; k < n; k++) {
                                if (temp[k][i] != 0) {
                                    temp[j][i] = temp[k][i];
                                    temp[k][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;

            // down (x값 증가)
            case 3:
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (temp[j][i] == 0) {
                            for (int k = j - 1; k >= 0; k--) {
                                if (temp[k][i] != 0) {
                                    temp[j][i] = temp[k][i];
                                    temp[k][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (temp[j][i] != 0) {
                            for (int k = j - 1; k >= 0; k--) {
                                if (temp[k][i] == temp[j][i]) {
                                    temp[j][i] *= 2;
                                    temp[k][i] = 0;
                                    break;
                                } else if (temp[k][i] != 0) {
                                    break;
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j >= 0; j--) {
                        if (temp[j][i] == 0) {
                            for (int k = j - 1; k >= 0; k--) {
                                if (temp[k][i] != 0) {
                                    temp[j][i] = temp[k][i];
                                    temp[k][i] = 0;
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
        }
    }
}