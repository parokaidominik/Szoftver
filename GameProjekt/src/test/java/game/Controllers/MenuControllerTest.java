package game.Controllers;

import game.Controllers.MenuController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuControllerTest {

    @Test
    void getPlayerOne() {
        var menu = new MenuController();
        MenuController.p1 = "Sajt";
        assertEquals("Sajt",menu.getPlayerOne());
    }

    @Test
    void getPlayerTwo() {
        var menu = new MenuController();
        MenuController.p2 = "Cheese";
        assertEquals("Cheese",menu.getPlayerTwo());
    }
}