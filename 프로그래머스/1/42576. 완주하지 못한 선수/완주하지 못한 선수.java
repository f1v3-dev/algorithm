import java.util.HashMap;
import java.util.Map;

class Solution {
public String solution(String[] participant, String[] completion) {

        // 참가자 - 완주자
        Map<String, Integer> member = new HashMap<>();

        for (String mem : participant) {
            member.put(mem, member.getOrDefault(mem, 0) + 1);
        }

        for (String complete : completion) {
            if (member.get(complete) > 1) {
                member.put(complete, member.getOrDefault(complete, 0) - 1);
                continue;
            }
            member.remove(complete);
        }

        StringBuilder sb = new StringBuilder();
        for (String mem : member.keySet()) {
            System.out.println(mem);
            sb.append(mem);
        }

        return sb.toString();
    }
}