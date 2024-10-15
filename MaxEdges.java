import java.util.Scanner;

class MaxEdges {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long l = scanner.nextLong();
            long middle = 0;

            if (k + l < n) {
                middle = n - (k + l);
            } else if (k + l > n) {
                long excess = (k + l) - n;
                k -= excess;
                l -= excess;
            }

            long result = (k * (middle + l)) + (middle * l);
            if (middle > 1) {
                result += (middle * (middle - 1)) / 2;
            }
            System.out.println(result);
        }
        scanner.close();
    }
}