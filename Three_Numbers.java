import java.io.*;
import java.util.*;

 class Three_Numbers {
    static final int MOD = 1_000_000_007;
    static final Random random = new Random();

    public static void main(String[] args) {
        FastInput input = new FastInput();
        PrintWriter output = new PrintWriter(System.out);
        
        int T = input.nextInt();
        while (T-- > 0) {
            long[] values = new long[3];
            for (int i = 0; i < 3; i++) values[i] = input.nextLong();
            Arrays.sort(values);
            long a = values[0], b = values[1], c = values[2];
            
            if ((a % 2 == b % 2) && (b % 2 == c % 2)) {
                long midpoint = (b + c) / 2;
                output.println(3 * midpoint - (a + b + c));
            } else {
                output.println(-1);
            }
        }
        output.close();
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    static class FastInput {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        
        String next() {
            while (!st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); } 
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
}
