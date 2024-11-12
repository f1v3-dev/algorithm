class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        String[] arr = s.split("");
        
        for (String str : arr) {
            count = " ".equals(str) ? 0 : count + 1;
            sb.append(count % 2 == 0 ? str.toLowerCase() : str.toUpperCase());
        }
        
        return sb.toString();
    }
}