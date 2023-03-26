import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // long int = 4Byte
        // long long int = 8Byte

        for (int i = 0; i < N/4; i++){
            System.out.print("long ");
        }
        System.out.println("int");
    }
}