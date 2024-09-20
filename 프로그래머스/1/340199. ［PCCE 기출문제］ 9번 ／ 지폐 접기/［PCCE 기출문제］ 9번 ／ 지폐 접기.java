class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (!isPossible(wallet, bill)) {
            fold(bill);
            answer++;
        }

        return answer;
    }

    public boolean isPossible(int[] wallet, int[] bill) {
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);

        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);

        return walletMax >= billMax && walletMin >= billMin;
    }

    public void fold(int[] bill) {
        int max = Math.max(bill[0], bill[1]);
        int min = Math.min(bill[0], bill[1]);

        bill[0] = max / 2;
        bill[1] = min;
    }
}