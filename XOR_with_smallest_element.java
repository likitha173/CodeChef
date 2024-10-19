import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            long y = sc.nextLong();
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                pq.add(sc.nextInt());
            }
            
            while (y > 0 && (pq.peek() ^ x) > pq.peek()) {
                pq.add(pq.poll() ^ x);
                y--;
            }
            
            if (y % 2 != 0) {
                pq.add(pq.poll() ^ x);
            }
            
            List<Integer> result = new ArrayList<>();
            while (!pq.isEmpty()) {
                result.add(pq.poll());
            }
            
            Collections.sort(result);
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}