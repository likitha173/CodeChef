import java.util.*;
import java.lang.*;
import java.io.*;

class Survive_in_ChocoLand
{
    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int S = sc.nextInt();

            if (K > N) {
                System.out.println(-1);
                continue;
            }

            int totalChocolates = K * S;
            int availableDays = S - (S / 7);
            int requiredDays = (totalChocolates + N - 1) / N;

            if (requiredDays > availableDays) {
                System.out.println(-1);
            } else {
                System.out.println(requiredDays);
            }
        }
    }
}