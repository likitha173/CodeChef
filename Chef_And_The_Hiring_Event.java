import java.util.*;
import java.lang.*;
import java.io.*;

class Chef_And_The_Hiring_Event
{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        int[] arr = {0, 2, 4, 6, 8};

        while (t-- > 0) {
            long n = in.nextLong();

            if (n == 1) {
                out.println(0);
                continue;
            }

            StringBuilder base5 = new StringBuilder();
            convertToBase5(base5, n);
            adjustBase5(base5);

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < base5.length(); i++) {
                result.append(arr[base5.charAt(i) - '0']);
            }

            out.println(result);
        }

        out.close();
    }

    public static void convertToBase5(StringBuilder sbr, long n) {
        if (n == 0) {
            sbr.append(0);
            return;
        }

        while (n > 0) {
            long remainder = n % 5;
            sbr.insert(0, remainder);
            n /= 5;
        }
    }

    public static void adjustBase5(StringBuilder sbr) {
        int n = sbr.length() - 1;

        while (n >= 0) {
            if (sbr.charAt(n) == '0') {
                sbr.setCharAt(n--, '4');
            } else {
                if (n == 0 && sbr.charAt(0) == '1') {
                    sbr.deleteCharAt(0);
                } else {
                    sbr.setCharAt(n, (char) (sbr.charAt(n) - 1));
                }
                break;
            }
        }
    }
}