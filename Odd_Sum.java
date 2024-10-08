import java.util.*;
import java.io.*;

class Odd_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        FastReader sc = new FastReader(); 
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt(); 
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); 
            if (n <= 2) {
                out.println(1);
                continue;
            }
            
            out.println((long)(n - 1) * (long)(n - 2) + 1); 
        }
        out.flush();
    }

    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        
        int[] arrayIn(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}