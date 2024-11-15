class Solution {
    public String solution(String new_id) {

        // id = 3 ~ 15
        // a-z, 0-9, -,_,.
        // startWiths . X

        // 1. toLowerCase
        new_id = new_id.toLowerCase();

        // 2. Pattern Matching
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3. 연속되는 '.' 한개로 묶기
        new_id = new_id.replaceAll("[.]{2,}", ".");

        // 4. 처음과 끝 에 '.' 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // 5. 빈 문자열인가? -> "a" 대입
        if (new_id.isEmpty()) {
            new_id = "a";
        }

        // 6. 길이가 16자 이상이면 15개 문자까지 짜른 후 끝에 '.' 존재하는지 체크 (4번?)
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }

        // 7. 2자 이하일 경우, 마지막 문자를 길이가 3 될 때 까지 반복
        if (new_id.length() <= 2) {
            while (new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }

        return new_id;
    }
}