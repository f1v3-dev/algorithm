import java.util.*;

class Solution {
    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        initSet(str1, list1);
        initSet(str2, list2);

        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536;
        }

        int intersection = 0;

        for (String str : list1) {
            if (list2.contains(str)) {
                intersection++;
                list2.remove(str);
            }
        }

        int union = list1.size() + list2.size();

        return (int) ((double) intersection / union * 65536);
    }

    private static void initSet(String str, List<String> list) {
        for (int i = 0; i < str.length() - 1; i++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i + 1);

            if (Character.isLetter(ch1) && Character.isLetter(ch2)) {
                list.add(ch1 + "" + ch2);
            }
        }
    }
}
