import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int t;
    static int p;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        solve();
        System.out.println(sb);
    }

    private static void solve() {
        // 티셔츠는 같은 사이즈의 t장 묶음으로만 주문
        // 펜은 한 종류로 p자루 묶음으로만 주문 + 한 자루씩 주문 가능

        // 티셔츠 묶음 개수 구하기
        int shirt = 0;
        for (int i = 0; i < 6; i++) {
            int bundle = arr[i] / t;
            int remainShirt = arr[i] % t;
            if (remainShirt > 0) {
                bundle++;
            }

            shirt += bundle;
        }

        sb.append(shirt)
                .append("\n");

        // 펜 묶음 개수 구하기
        int pen = n / p;
        int remainPen = n % p;

        sb.append(pen)
                .append(" ")
                .append(remainPen);
    }
}