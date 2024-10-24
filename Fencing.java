import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Fencing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long N = scanner.nextLong();
            long M = scanner.nextLong();
            long K = scanner.nextLong();
            Set<String> plants = new HashSet<>();
            for (int i = 0; i < K; i++) {
                long r = scanner.nextLong();
                long c = scanner.nextLong();
                plants.add(r + "," + c);
            }
            long fences = 0;
            for (String plant : plants) {
                String[] coords = plant.split(",");
                long x = Long.parseLong(coords[0]);
                long y = Long.parseLong(coords[1]);
                if (!plants.contains((x + 1) + "," + y)) {
                    fences++;
                }
                if (!plants.contains((x - 1) + "," + y)) {
                    fences++;
                }
                if (!plants.contains(x + "," + (y + 1))) {
                    fences++;
                }
                if (!plants.contains(x + "," + (y - 1))) {
                    fences++;
                }
            }
            System.out.println(fences);
        }
        scanner.close();
    }
}