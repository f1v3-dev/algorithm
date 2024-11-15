class Solution {
    public int solution(int n) {

        String binary = Integer.toBinaryString(n);
        int count = 0;
        
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                count++;
            }
        }

        while (true) {
            String next = Integer.toBinaryString(++n);
            int nextCount = 0;
            
            for (int i = 0; i < next.length(); i++) {
                if (next.charAt(i) == '1') {
                    nextCount++;
                }
                
                if (nextCount > count) {
                    break;
                }
            }
            
            if (nextCount == count) {
                return n;
            }
        }
        

    }
}
