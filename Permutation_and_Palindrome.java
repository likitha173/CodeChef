import java.util.*;
import java.io.*;

class Permutation_and_Palindrome {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            int n = s.length();
            Map<Character, List<Integer>> freq = new HashMap<>();
            int[] result = new int[n];
            int start = 0, end = n - 1;
            boolean isImpossible = false;
            char oddChar = 0;
            int oddCount = 0;

            for (int i = 0; i < n; i++) {
                freq.putIfAbsent(s.charAt(i), new ArrayList<>());
                freq.get(s.charAt(i)).add(i + 1);
            }

            for (Map.Entry<Character, List<Integer>> entry : freq.entrySet()) {
                List<Integer> indices = entry.getValue();
                if (indices.size() % 2 != 0) {
                    oddCount++;
                    oddChar = entry.getKey();
                }
                if (oddCount > 1 || (oddCount == 1 && n % 2 == 0)) {
                    isImpossible = true;
                    break;
                }
            }

            if (isImpossible) {
                System.out.println(-1);
            } else {
                for (Map.Entry<Character, List<Integer>> entry : freq.entrySet()) {
                    List<Integer> indices = entry.getValue();
                    if (indices.size() % 2 == 0) {
                        for (int i = 0; i < indices.size(); i += 2) {
                            result[start++] = indices.get(i);
                            result[end--] = indices.get(i + 1);
                        }
                    }
                }
                if (n % 2 != 0) {
                    for (int index : freq.get(oddChar)) {
                        result[start++] = index;
                    }
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(result[i] + " ");
                }
                System.out.println();
            }
        }
    }
}
