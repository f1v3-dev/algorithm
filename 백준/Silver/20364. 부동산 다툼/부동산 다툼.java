import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // Tree 역할을 하는 배열 생성
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < q; i++) {
            int ground = Integer.parseInt(br.readLine());

            int currentGround = ground;
            int firstMeet = 0;
            while (currentGround > 0) {
                if (visited[currentGround]) {
                    // 원하는 땅까지 가는 길에 이미 다른 오리가 점유한 땅이 있다면 점유된 땅의 번호
                    // 원하는 땅에 갈 수 없다면 처음 마주치는 점유된 땅의 번호를 출력애햐 함
                    firstMeet = currentGround;
                }

                // 상위 노드 탐색 (부모 = 자식 * 2 or 자식 * 2 + 1)
                currentGround /= 2;
            }

            if (currentGround == 0) {
                visited[ground] = true;
            }

            sb.append(firstMeet).append("\n");
        }

        System.out.println(sb);
    }
}