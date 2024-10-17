import java.util.*;
import java.io.*;

 class Zebra_Crossing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            String s = br.readLine();
            
            if (k > n || !canJump(s, k)) {
                output.append("-1\n");
                continue;
            }

            int pos = 0;
            int farthest = n - 1;
            if (k % 2 == 1) {
                while (pos < farthest) {
                    if (s.charAt(pos) != s.charAt(farthest)) {
                        output.append(farthest + 1).append("\n");
                        break;
                    }
                    farthest--;
                }
            } else {
                while (pos < farthest) {
                    if (s.charAt(pos) == s.charAt(farthest)) {
                        output.append(farthest + 1).append("\n");
                        break;
                    }
                    farthest--;
                }
            }
            if (farthest == pos) {
                output.append("-1\n");
            }
        }
        System.out.print(output.toString());
    }

    private static boolean canJump(String s, int k) {
        int jumps = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                jumps++;
            }
            if (jumps >= k) {
                return true;
            }
        }
        return false;
    }
}