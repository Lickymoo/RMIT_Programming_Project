package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;

import java.io.IOException;
import static rmit.f21b.game.Util.*;


public class EnteredAreaScene extends Scene {
    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        displayDialogue("You have entered " + player.getMapSection().name + "\n\n" + player.getMapSection().description);
        enterToContinue();

        player.getMapSection().onEnter(player);

        Main.sceneManager.setCurrentScene(new IdleScene(), player);
    }
}
