package game.PlayerManagement;

public class Player {
    private final String name;
    private final int id;
    private final String played;
    private final String wins;
    private final String winrate;

    /**
     * This whole class helps the tableview to show us the scoreboard.
     */
    public Player(String name, int id, String played, String wins, String winrate) {

        this.name = name;
        this.id = id;
        this.played = played;
        this.wins = wins;
        this.winrate = winrate;

    }

    public String getWinrate() {
        return winrate;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPlayed() {
        return played;
    }

    public String getWins() {
        return wins;
    }

}
