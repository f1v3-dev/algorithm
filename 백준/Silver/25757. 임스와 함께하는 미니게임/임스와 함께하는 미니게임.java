import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Y : 윷놀이 (2명)
 * F : 같은 그림 찾기 (3명)
 * O : 원카드 (4명)
 */
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        String game = input[1];

        Map<String, Integer> map = new HashMap<>();

        // 같이 게임할 플레이어의 정보를 HashMap에 저장
        for (int i = 0; i < N; i++) {
            String player = br.readLine();
            map.put(player, map.getOrDefault(player, 0) + 1);
        }


        System.out.println(play(game, map));

    }

    private static int play(String game, Map<String, Integer> map) {

        switch (game) {
            case "Y":
                return playY(map);
            case "F":
                return playF(map);
            case "O":
                return playO(map);
            default:
                throw new IllegalArgumentException("Unsupported game type!");
        }
    }

    /**
     * [원카드]
     * 원카드는 4명이서 진행
     */
    private static int playO(Map<String, Integer> map) {

        int count = 0;
        int playerCount = 0;

        for (String s : map.keySet()) {
            playerCount++;

            if (playerCount == 3) {
                count++;
                playerCount = 0;
            }
        }

        return count;
    }

    /**
     * [같은 그림 찾기]
     * 같은 그림 찾기는 3명이서 진행
     */
    private static int playF(Map<String, Integer> map) {

        int count = 0;

        int playerCount = 0;
        for (String s : map.keySet()) {
            playerCount++;

            if (playerCount == 2) {
                count++;
                playerCount = 0;
            }
        }

        return count;
    }

    /**
     * [윷놀이]
     * 윷놀이는 2명이서 진행하기 때문에 HashMap의 사이즈를 반환
     */
    private static int playY(Map<String, Integer> map) {
        return map.size();
    }
}