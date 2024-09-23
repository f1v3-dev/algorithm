class Solution {
    public String solution(String s) {

        int min = findMin(s);
        int max = findMax(s);

        return min + " " + max;
    }

    public int findMin(String s) {
        String[] arr = s.split(" ");

        int min = Integer.MAX_VALUE;

        for (String number : arr) {
            int num = Integer.parseInt(number);
            min = Math.min(min, num);
        }

        return min;
    }

    public int findMax(String s) {
        String [] arr = s.split(" ");

        int max = Integer.MIN_VALUE;
        for (String number : arr) {
            int num = Integer.parseInt(number);
            max = Math.max(num, max);
        }

        return max;
    }
}