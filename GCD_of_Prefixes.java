import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class GCD_of_Prefixes {
    static final long MOD = 1000000007L;
    static FastInputReader input = new FastInputReader();

    public static void main(String[] args) throws IOException {
        PrintWriter output = new PrintWriter(System.out);
        int testCases = input.nextInt();
        while (testCases-- > 0) {
            int size = input.nextInt();
            long[] array = input.readLongArray(size);
            boolean isValid = true;
            for (int j = 1; j < size; j++) {
                if (array[j] > array[j - 1] || array[j - 1] % array[j] != 0) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                output.println(-1);
            } else {
                for (long element : array) {
                    output.print(element + " ");
                }
            }
            output.println();
        }
        output.close();
    }

    static class FastInputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastInputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        int[] readIntArray(int n) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = nextInt();
            }
            return result;
        }

        long[] readLongArray(int n) {
            long[] result = new long[n];
            for (int i = 0; i < n; i++) {
                result[i] = nextLong();
            }
            return result;
        }
    }
}