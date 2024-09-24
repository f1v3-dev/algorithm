class Solution {
    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        boolean isBeforeBlank = true;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == ' ') {
                result.append(current);
                isBeforeBlank = true;
            } else {

                if (isBeforeBlank) {
                    result.append(Character.toUpperCase(current));
                } else {
                    result.append(Character.toLowerCase(current));
                }
                isBeforeBlank = false;
            }
        }

        return result.toString();
    }
}