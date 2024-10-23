import java.util.Scanner;

 class Chef_and_Water_Car {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            long n = scanner.nextLong();
            long v = scanner.nextLong();
            long maxCost = (n * (n - 1)) / 2;
            long minCost = (v - 1) + ((n - v) * (n - v + 1)) / 2;
            if (v >= n) minCost = n - 1;
            System.out.println(maxCost + " " + minCost);
        }
        scanner.close();
    }
}