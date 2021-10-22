package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.util.ItemBase;

import java.io.IOException;

import static rmit.f21b.game.Util.*;


public class EndingScene extends Scene {

    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        println("You have completed the game");
        println("Congratulations!!");
        enterToContinue();
    }
}
