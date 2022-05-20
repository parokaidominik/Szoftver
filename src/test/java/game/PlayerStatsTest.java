package game;

import game.PlayerManagement.PlayerStats;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStatsTest {

    @Test
    void setStats() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
    }

    @Test
    void getWinPercentage() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "30";
        String wins = "15";
        int id = 4;
        float winsf = 15;
        float playedf = 30;
        float test = (winsf/playedf)*100;
        String expected = test+" %";
        PlayerStats.setStats(name,id,wins,played);
        assertEquals(expected,stats.getWinPercentage(id));
    }

    @Test
    void getName() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        assertEquals(name,stats.getName(id));
    }

    @Test
    void getID() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        assertEquals(id,stats.getID(name));

    }

    @Test
    void isExistTrue() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        assertEquals(true,stats.isExist(name));

    }
    @Test
    void isExistFalse() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        assertEquals(false,stats.isExist("Peti"));

    }

    @Test
    void getWins() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        assertEquals(wins,stats.getWins(id));
    }

    @Test
    void getPlayed() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        assertEquals(played,stats.getPlayed(id));
    }

    @Test
    void setWins() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        stats.setWins(15,id);
        assertEquals("15",stats.getWins(id));
    }

    @Test
    void setPlayed() {
        var stats = new PlayerStats();
        String name = "Jani";
        String played = "31";
        String wins = "11";
        int id = 4;
        PlayerStats.setStats(name,id,wins,played);
        stats.setPlayed(37,id);
        assertEquals("37",stats.getPlayed(id));
    }
}