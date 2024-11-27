import java.util.*;

class Solution {

    static Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        for (String s : info) {
            String[] split = s.split(" ");
            combination(split, 0, new StringBuilder());
        }
        
        for (List<Integer> scores : map.values()) {
            Collections.sort(scores);
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String line = query[i].replaceAll(" and ", "");
            String[] split = line.split(" ");

            if (map.containsKey(split[0])) {
                answer[i] = binarySearch(split[0], Integer.parseInt(split[1]));
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private static int binarySearch(String key, int point) {
        List<Integer> list = map.get(key);

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (list.get(mid) < point) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return list.size() - start;
    }

    private static void combination(String[] str, int depth, StringBuilder sb) {


        if (depth == 4) {

            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString(), new ArrayList<>());
            }

            int point = Integer.parseInt(str[4]);
            map.get(sb.toString()).add(point);

            return;
        }

        int len = sb.length();
        combination(str, depth + 1, sb.append(str[depth]));
        sb.setLength(len);

        combination(str, depth + 1, sb.append("-"));
        sb.setLength(len);
    }
}
