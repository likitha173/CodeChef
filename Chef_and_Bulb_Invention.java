import java.util.Scanner;

 class Chef_and_Bulb_Invention {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while (t-- > 0) {
            long n = sc.nextLong();
            long p = sc.nextLong();
            long k = sc.nextLong();

            long mod_p = p % k;
            long ans;
  
            if (n % k <= mod_p - 1) {
                ans = (n % k) * (n / k + 1) + (mod_p - n % k) * (n / k);
                ans += (p / k + 1);
            } else {
                ans = (mod_p) * (n / k + 1);
                ans += (p / k + 1);
            }
       
            System.out.println(ans);
        }
        
        sc.close();
    }
}