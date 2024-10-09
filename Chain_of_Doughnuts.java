import java.util.Arrays;
import java.util.Scanner;

class Chain_of_Doughnuts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            int m = sc.nextInt();
            long[] d = new long[m];

            for (int i = 0; i < m; i++) {
                d[i] = sc.nextLong();
            }

            Arrays.sort(d);

            long b = 0;
            int i = 0;

            while (m >= 1) {
                m -= (d[i] + 1);
                b += d[i];
                i++;
            }

            System.out.println(b + m);
        }

        sc.close();
    }
}