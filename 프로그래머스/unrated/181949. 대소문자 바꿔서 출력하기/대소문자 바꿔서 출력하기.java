import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String result = "";
        
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            // 65 = A, 97 = a
            if ((65 <= ch) && (ch <= 90)) {
                result += (char)(ch + 32);
            }
            else if ((97 <= ch) && (ch <= 122)) {
                result += (char)(ch - 32);
            }
        }
        
        System.out.println(result);
    }
}