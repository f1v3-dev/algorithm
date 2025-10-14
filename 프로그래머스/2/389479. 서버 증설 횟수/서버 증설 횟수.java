class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[players.length];
        
        for (int i = 0; i < players.length; i++) {
            int player = players[i];
            int needServer = (int) Math.ceil(player / m);
            
            if (server[i] < needServer) {
                needServer -= server[i];
                for (int j = i; j < Math.min(i + k, players.length); j++) {
                    server[j] += needServer;
                }
                
                answer += needServer;
            }
        }

        return answer;
    }
}