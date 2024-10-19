import java.util.*;
import java.lang.*;

class Concat_Sort {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(canBeSorted(arr, n) ? "YES" : "NO");
        }
        sc.close();
    }

    static boolean canBeSorted(int[] arr, int n) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        int left = 0, right = 0;
        Set<Integer> indices = new HashSet<>();
        
        while (right < n) {
            while (left < n && sortedArr[right] != arr[left]) {
                left++;
            }
            if (left == n) {
                break;
            }
            indices.add(left);
            left++;
            right++;
        }
        
        if (right == n) {
            return true;
        }
        
        left = 0;
        while (right < n) {
            if (indices.contains(left)) {
                left++;
                continue;
            }
            if (sortedArr[right] != arr[left]) {
                return false;
            }
            left++;
            right++;
        }
        return true;
    }
}