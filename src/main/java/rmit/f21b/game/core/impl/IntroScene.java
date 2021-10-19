package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.item.impl.*;

import java.io.IOException;

import static rmit.f21b.game.Util.*;

public class IntroScene extends Scene {
    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        println("");

        println("This game is best experienced with a fullscreen console.");
        println("");
        println("Created by: Austin Craig, Lyndon Tokai & Mitchell Gertrude");
        println("Press ENTER twice to start your adventure");
        println("");
        enterToContinue();
        clearScreen();

        displayDialogue("You've been caught in a storm and shipwrecked. \n You wake up on the shoreline to see swirling clouds in the distance and all you know is that you must go inland.");
        enterToContinue();
        clearScreen();

        //Temp
        player.addInventoryItem(new HealthPotionItem());
        player.addInventoryItem(new PointySwordItem());
        player.addInventoryItem(new ShabbySwordItem());
        player.addInventoryItem(new MonstrousCrabShellItem());
        player.addInventoryItem(new SnakesFangItem());
        //

        Main.sceneManager.setCurrentScene(new IdleScene(), player);
    }
}
