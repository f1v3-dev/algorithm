import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        Deque<Character> skillQueue = new LinkedList<>();

        for (String skillTree : skill_trees) {

            boolean isPossible = true;
            for (char ch : skill.toCharArray()) {
                skillQueue.add(ch);
            }

            char[] trees = skillTree.toCharArray();

            for (char tree : trees) {
                if (skillQueue.isEmpty()) {
                    break;
                }

                // 선행 스킬 순서에 맞는 스킬트리인지 확인
                if (!skillQueue.peekFirst().equals(tree)) {
                    if (skill.contains(String.valueOf(tree))) {
                        isPossible = false;
                        break;
                    }
                } else {
                    skillQueue.pollFirst();
                }
            }

            answer = isPossible ? answer + 1 : answer;

            skillQueue.clear();
        }

        return answer;
    }
}
