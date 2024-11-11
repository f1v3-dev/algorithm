class Solution {
    public boolean solution(int x) {
        
        int sum = 0;
        String[] str = String.valueOf(x).split("");
        
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        
        return x % sum == 0;
    }
}