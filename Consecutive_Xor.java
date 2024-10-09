import java.util.*;
import java.lang.*;
import java.io.*;

class Consecutive_Xor {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 
        while (T-- > 0) {
            int N = sc.nextInt();  
            int[] A = new int[N];  
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            
            if (N % 2 == 1) {
                System.out.println("YES");
            } else {
                for (int i = 0; i < N - 1; i++) {
                    A[i + 1] = A[i] ^ A[i + 1]; 
                    A[i] = 0;  
                }
                Set<Integer> distinctValues = new HashSet<>();
                for (int num : A) {
                    distinctValues.add(num);
                }
                if (distinctValues.size() == 1) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
        sc.close();
    }
}