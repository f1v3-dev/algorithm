import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    static int n;
    static int k;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        arr = new int[k];
        input = br.readLine().split(" ");

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        solve();
    }

    private static void solve() {
        int count = 0;
        for (int i = 0; i < k; i++) {
            // 1. 멀티탭에 이미 꽂혀있거나, 비어있어 꽂을 수 있는 경우
            if (set.contains(arr[i]) || isPossible(arr[i])) {
                continue;
            }

            // 2. 새로운 전기용품을 꽂아야 하는 경우
            // 꽂혀있는 전기용품 중 가장 나중에 사용될 것을 선택
            Map<Integer, Integer> hm = new HashMap<>();
            for (Integer item : set) {
                hm.put(item, Integer.MAX_VALUE); // 초기값을 MAX로 설정
            }

            for (int j = i + 1; j < k; j++) {
                if (hm.containsKey(arr[j]) && hm.get(arr[j]) == Integer.MAX_VALUE) {
                    hm.put(arr[j], j);
                }
            }

            // 3. Map에 저장된 값이 가장 큰 것을 제거
            int max = -1;
            int target = 0;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    target = entry.getKey();
                }
            }

            set.remove(target);
            set.add(arr[i]);
            count++;
        }

        System.out.println(count);
    }

    private static boolean isPossible(int num) {
        if (set.size() < n) {
            set.add(num);
            return true;
        }

        return false;
    }
}
