package rmit.f21b.game.core.impl;

import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;

import java.io.IOException;

import static rmit.f21b.game.Util.*;


public class PlayerDeathScene extends Scene {

    @Override
    public void run(Player player) throws IOException {
        clearScreen();

        displayDialogue("You have died! \n Game Over." );
        enterToContinue();
    }
}
