import java.util.*;
import java.lang.*;
import java.io.*;

class Bench_Press
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            int N = sc.nextInt(); 
            int W = sc.nextInt(); 
            int Wr = sc.nextInt();

            int[] weights = new int[N]; 
            for (int i = 0; i < N; i++) {
                weights[i] = sc.nextInt();
            }

            if (Wr >= W) {
                System.out.println("YES");
                continue;
            }

            Arrays.sort(weights);
      
            int totalWeight = Wr;
            int i = N - 1;
            
            while (i > 0) {
                if (weights[i] == weights[i - 1]) {
                    totalWeight += 2 * weights[i];
                    i -= 2; // Move to the next pair
                } else {
                    i--;
                }

                if (totalWeight >= W) {
                    break;
                }
            }

            if (totalWeight >= W) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}