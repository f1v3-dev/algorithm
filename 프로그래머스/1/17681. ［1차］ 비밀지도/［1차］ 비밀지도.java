class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] map = new String[n];
        
        for (int i = 0; i < n; i++) {
            String line1 = toBinaryString(arr1[i], n);
            String line2 = toBinaryString(arr2[i], n);
            
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                if (line1.charAt(j) == '1' || line2.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            
            map[i] = sb.toString();
        }
        
        return map;
    }
    
    private String toBinaryString(int number, int len) {
        String binary = Integer.toBinaryString(number);
        return "0".repeat(len - binary.length()) + binary;
    }
}