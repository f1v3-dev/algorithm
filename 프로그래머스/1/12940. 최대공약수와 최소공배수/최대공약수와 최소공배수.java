class Solution {
    public int[] solution(int n, int m) {
        
        int gcd = gcd(n, m);
        int lcm = n * m / gcd;
        
        return new int[]{ gcd, lcm };
    }
    
    private static int gcd(int n, int m) {
        if (n % m == 0) {
            return m;
        }
        
        return gcd(m, n % m);
    }
}