import java.util.*;

 class Maximum_Subarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            long prefixSumA = 0, maxPrefixSumA = 0;
            
            // Read array `a` and calculate prefix sums
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                prefixSumA += a[i];
                maxPrefixSumA = Math.max(maxPrefixSumA, prefixSumA);
            }

            int m = scanner.nextInt();
            int[] b = new int[m];
            long totalPositiveB = 0;

            // Read array `b` and sum only positive values
            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
                if (b[i] > 0) {
                    totalPositiveB += b[i];
                }
            }

            // Calculate suffix sums for `a` and find maximum
            long suffixSumA = 0;
            for (int i = n - 1; i >= 0; i--) {
                suffixSumA += a[i];
                maxPrefixSumA = Math.max(maxPrefixSumA, suffixSumA);
            }

            // Final result is the maximum prefix/suffix sum of `a` combined with total positive sum of `b`
            System.out.println(maxPrefixSumA + totalPositiveB);
        }
        scanner.close();
    }
}
