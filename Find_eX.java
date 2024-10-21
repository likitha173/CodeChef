import java.io.*;

class Find_eX
{
    private static BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        int testCases = Integer.parseInt(inputReader.readLine().trim());
        while (testCases-- > 0) {
            int[] values = toIntArray(inputReader.readLine().trim());
            long x = values[0], y = values[1], z = values[2], w = values[3];
            x = calculateMod(x, y);
            z = calculateMod(z, w);
            if ((x + 1 == y && z + 1 != w) || (x + 1 != y && z + 1 == w)) {
                long lcm = (w * y) / computeGCD(y, w);
                outputWriter.write((lcm - x) + "\n");
            } else {
                outputWriter.write("1\n");
            }
        }
        outputWriter.flush();
    }

    private static long computeGCD(long a, long b) {
        return b == 0 ? a : computeGCD(b, a % b);
    }

    private static long calculateMod(long n, long m) {
        return n >= 0 ? n % m : (m - Math.abs(n) % m) % m;
    }

    private static int[] toIntArray(String str) {
        String[] parts = str.split("\\s+");
        int[] result = new int[parts.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(parts[i]);
        }
        return result;
    }

    private static long[] toLongArray(String str) {
        String[] parts = str.split("\\s+");
        long[] result = new long[parts.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Long.parseLong(parts[i]);
        }
        return result;
    }
}
