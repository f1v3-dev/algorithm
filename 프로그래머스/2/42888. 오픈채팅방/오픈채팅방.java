import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        // key: uid, value: nickname
        Map<String, String> userMap = new HashMap<>();

        // uid + " " + command
        List<String> list = new ArrayList<>();

        for (String r : record) {
            String[] split = r.split(" ");
            String command = split[0];
            String uid = split[1];
            String nickname = "";
            if (split.length == 3) {
                nickname = split[2];
            }

            if ("Enter".equals(command)) {
                userMap.put(uid, nickname);
                list.add(uid + " " + command);
            } else if ("Leave".equals(command)) {
                list.add(uid + " " + command);
            } else {
                userMap.put(uid, nickname);
            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String[] split = list.get(i).split(" ");
            String uid = split[0];
            String command = split[1];

            if ("Enter".equals(command)) {
                answer[i] = userMap.get(uid) + "님이 들어왔습니다.";
            } else {
                answer[i] = userMap.get(uid) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}