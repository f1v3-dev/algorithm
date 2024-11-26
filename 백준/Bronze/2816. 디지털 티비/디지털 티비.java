import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int kbs1 = 0;
        int kbs2 = 0;

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            if ("KBS1".equals(input)) {
                kbs1 = i;
            } else if ("KBS2".equals(input)) {
                kbs2 = i;
            }
        }

        // 1. KBS1의 위치를 찾고 맨 위로 올리는 과정
        sb.append("1".repeat(kbs1));
        sb.append("4".repeat(kbs1));

        // KBS1이 KBS2보다 아래있는 경우 대비
        if (kbs1 > kbs2) {
            kbs2++;
        }

        // 2. KBS2의 위치를 찾고 맨 위로 올리는 과정
        sb.append("1".repeat(kbs2));
        sb.append("4".repeat(kbs2 - 1));

        System.out.println(sb);

    }
}