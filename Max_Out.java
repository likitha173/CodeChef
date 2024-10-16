import java.util.*;
import java.io.*;

class Max_Out {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(arr);
            
            int result = 0;
            for (int i = 0; i < n - 1; i++) {
                result = Math.max(result, arr[i] % arr[n - 1]);
            }

            System.out.println(result);
        }
    }
}
