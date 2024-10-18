import java.util.*;

class UEFA_Champions_League {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            Map<String, int[]> teamData = new HashMap<>();
            
            for (int i = 0; i < 12; i++) {
                String homeTeam = sc.next();
                int homeGoals = sc.nextInt();
                sc.next(); // Skip 'vs.'
                int awayGoals = sc.nextInt();
                String awayTeam = sc.next();
                
                teamData.putIfAbsent(homeTeam, new int[2]);
                teamData.putIfAbsent(awayTeam, new int[2]);
                
                teamData.get(homeTeam)[1] += (homeGoals - awayGoals);
                teamData.get(awayTeam)[1] += (awayGoals - homeGoals);
                
                if (homeGoals > awayGoals) {
                    teamData.get(homeTeam)[0] += 3;
                } else if (awayGoals > homeGoals) {
                    teamData.get(awayTeam)[0] += 3;
                } else {
                    teamData.get(homeTeam)[0] += 1;
                    teamData.get(awayTeam)[0] += 1;
                }
            }
            
            List<String> teams = new ArrayList<>(teamData.keySet());
            teams.sort((team1, team2) -> {
                int[] data1 = teamData.get(team1);
                int[] data2 = teamData.get(team2);
                if (data1[0] != data2[0]) {
                    return data2[0] - data1[0];
                }
                return data2[1] - data1[1];
            });
            
            System.out.println(teams.get(0) + " " + teams.get(1));
        }
        
        sc.close();
    }
}