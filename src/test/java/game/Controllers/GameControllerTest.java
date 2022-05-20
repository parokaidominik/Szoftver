package game.Controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void isMoved() {
    }

    @Test
    public void isThisAWinningSituation(){
        var controller = new GameController();
        String game[][] = new String[10][10];
        game [1][1] = "BLUE";
        game [1][2] = "BLUE";
        game [1][3] = "BLUE";
        controller.isGameFinished(game, "BLUE");
        assertEquals(true,controller.win);
    }

    @Test
    public void isThisAWinningSituation2(){
        var controller = new GameController();
        String game[][] = new String[10][10];
        game [1][1] = "BLUE";
        game [1][4] = "BLUE";
        game [1][3] = "BLUE";
        controller.isGameFinished(game, "BLUE");
        assertEquals(false,controller.win);
    }
}