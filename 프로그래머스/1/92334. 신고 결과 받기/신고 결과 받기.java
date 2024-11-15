import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        // Key: 신고 당한 사람
        // Value: 신고한 사람
        Map<String, Set<String>> map = new HashMap<>();

        for (String id : id_list) {
            map.put(id, new HashSet<>());
        }

        // ex. muzi -> frodo
        for (String r : report) {
            String[] split = r.split(" ");
            map.get(split[1]).add(split[0]);
        }

        // 신고를 k번 이상 받은 사람 뽑아
        Set<String> reportSet = new HashSet<>();
        for (String id : id_list) {
            Set<String> set = map.get(id);
            if (set.size() >= k) {
                reportSet.add(id);
            }
        }

        // reportSet에 있는 사람을 신고한 사람의 value++
        Map<String, Integer> reportMap = new HashMap<>();
        for (String id : reportSet) {
            Set<String> set = map.get(id);
            for (String s : set) {
                reportMap.put(s, reportMap.getOrDefault(s, 0) + 1);
            }
        }

        answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            Integer value = reportMap.get(id_list[i]);
            answer[i] = value == null ? 0 : value;
        }

        return answer;
    }
}
