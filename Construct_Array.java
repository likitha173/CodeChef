import java.util.*;
import java.io.*;

class Construct_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            if (n % 2 == 0) {
                for (int i = 0; i < n - 1; i++) {
                    if (i % 2 == 0) {
                        result.append("343 ");
                    } else {
                        result.append("-343 ");
                    }
                }
                result.append("243\n");
            } else {
                result.append("-1\n");
            }
        }
        
        System.out.print(result.toString());
    }
}