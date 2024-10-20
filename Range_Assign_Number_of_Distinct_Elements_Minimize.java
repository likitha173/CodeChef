import java.util.*;
import java.io.*;

class Range_Assign_Number_of_Distinct_Elements_Minimize {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            int first = Integer.parseInt(arr[0]);
            int last = Integer.parseInt(arr[N - 1]);
            
            if (first == last) {
                System.out.println("YES");
                continue;
            }
            
            boolean found = false;
            for (int i = 0; i < N - 1; i++) {
                int a = Integer.parseInt(arr[i]);
                int b = Integer.parseInt(arr[i + 1]);
                if (a == first && b == last) {
                    System.out.println("YES");
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                System.out.println("NO");
            }
        }
    }
}