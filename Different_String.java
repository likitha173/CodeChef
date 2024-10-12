import java.util.Scanner;

class Different_String {

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        String[] arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (arr[i].charAt(i) == '1') {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        
        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            solve(sc);
        }
        
        sc.close();
    }
}