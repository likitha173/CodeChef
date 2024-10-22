import java.util.*;
import java.io.*;

 class OR_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        
        while (t-- > 0) {
            String[] dimensions = reader.readLine().split(" ");
            int n = Integer.parseInt(dimensions[0]);
            int m = Integer.parseInt(dimensions[1]);
            int[][] matrix = new int[n][m];
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = line.charAt(j) - '0';
                    if (matrix[i][j] == 1) {
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }

            if (rows.isEmpty() && cols.isEmpty()) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        result.append("-1 ");
                    }
                    result.append("\n");
                }
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (matrix[i][j] == 1) {
                            result.append("0 ");
                        } else if (rows.contains(i) || cols.contains(j)) {
                            result.append("1 ");
                        } else {
                            result.append("2 ");
                        }
                    }
                    result.append("\n");
                }
            }
        }
        System.out.print(result);
    }
}