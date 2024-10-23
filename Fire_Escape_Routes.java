import java.util.*;
import java.io.*;

 class Fire_Escape_Routes {
    private static final long MOD = 1000000007;

    private static void dfs(List<List<Integer>> adj, boolean[] visited, int src, long[] count) {
        visited[src] = true;
        count[0]++;
        for (int neighbor : adj.get(src)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor, count);
            }
        }
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int totalRoutes = 0;
        long captainWays = 1;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                long[] count = new long[1];
                dfs(adj, visited, i, count);
                totalRoutes++;
                captainWays = (captainWays * count[0]) % MOD;
            }
        }

        System.out.println(totalRoutes + " " + captainWays);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }
}