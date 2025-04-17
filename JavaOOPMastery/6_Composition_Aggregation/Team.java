import java.util.List;
public class Team {
    private List<Player> players;
    public Team(List<Player> players) {
        this.players = players;
    }
    void showTeam() {
        for (Player p : players) {
            System.out.println(p.name);
        }
    }
    public static void main(String[] args) {
        List<Player> playerList = java.util.Arrays.asList(new Player("Alice"), new Player("Bob"));
        Team team = new Team(playerList);
        team.showTeam(); // Output: Alice\nBob
    }
}
