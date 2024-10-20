import java.util.*;
import java.io.*;

class Charges {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            String[] nk = br.readLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            char[] s = br.readLine().toCharArray();
            int[] changes = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x) - 1).toArray();
            
            int totalDistance = 0;
            for (int i = 1; i < n; i++) {
                totalDistance += (s[i] == s[i - 1]) ? 2 : 1;
            }

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < k; i++) {
                int index = changes[i];
                
                if (index > 0) {
                    if (s[index] == s[index - 1]) {
                        totalDistance -= 2;
                    } else {
                        totalDistance -= 1;
                    }
                }
                
                if (index < n - 1) {
                    if (s[index] == s[index + 1]) {
                        totalDistance -= 2;
                    } else {
                        totalDistance -= 1;
                    }
                }

                s[index] = (s[index] == '0') ? '1' : '0';

                if (index > 0) {
                    if (s[index] == s[index - 1]) {
                        totalDistance += 2;
                    } else {
                        totalDistance += 1;
                    }
                }
                
                if (index < n - 1) {
                    if (s[index] == s[index + 1]) {
                        totalDistance += 2;
                    } else {
                        totalDistance += 1;
                    }
                }

                output.append(totalDistance).append("\n");
            }

            System.out.print(output);
        }
    }
}