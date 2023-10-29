class Solution {
    public int[] solution(int[] num_list) {
        
        int left = num_list[num_list.length - 2];
        int right = num_list[num_list.length - 1];
        
        int addNumber = 0;
        if (left < right) {
            addNumber = right - left;
        } else {
            addNumber = right * 2;
        }
    
        
        int[] result = new int[num_list.length + 1];
        
        for (int i = 0; i < num_list.length; i++) {
            result[i] = num_list[i];
        }
        
        result[result.length - 1] = addNumber;
        return result;
    }
}