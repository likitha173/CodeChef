import java.util.Scanner;

class The_Vowel_Matrix {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long N = scanner.nextLong();
            long K = scanner.nextLong();
            String S = scanner.next();

            long vowelCount = 0;
            for (char c : S.toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    vowelCount++;
                }
            }

            long parts = vowelCount / K;
            long[] gaps = new long[(int)(parts - 1)];
            int index = 0; // Changed to int for index
            for (int i = 0; i < parts - 1; i++) {
                long currentVowel = 0;
                while (currentVowel < K) {
                    if (S.charAt(index) == 'a' || S.charAt(index) == 'e' || S.charAt(index) == 'i' || S.charAt(index) == 'o' || S.charAt(index) == 'u') {
                        currentVowel++;
                    }
                    index++;
                }
                long gapCount = 0;
                while (index < N && !isVowel(S.charAt(index))) {
                    gapCount++;
                    index++;
                }
                gaps[i] = gapCount;
            }

            long result = 1;
            for (long gap : gaps) {
                result = (result * (gap + 1)) % MOD;
            }
            System.out.println(result);
        }
        scanner.close();
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}