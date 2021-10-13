package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.item.impl.HealthPotionItem;
import rmit.f21b.game.item.impl.PointySwordItem;
import rmit.f21b.game.item.impl.SnakesFangItem;

import java.io.IOException;

import static rmit.f21b.game.Util.*;

public class IntroScene extends Scene {
    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        println(
                "██████╗ ██████╗  ██████╗",
                "██╔══██╗██╔══██╗██╔════╝",
                "██████╔╝██████╔╝██║  ███╗",
                "██╔══██╗██╔═══╝ ██║   ██║",
                "██║  ██║██║     ╚██████╔╝",
                "╚═╝  ╚═╝╚═╝      ╚═════╝ ");
        println("");

        println("Press ENTER twice to start your adventure");
        println("");
        enterToContinue();
        clearScreen();

        typeWriter("You have been caught in a storm and have been shipwrecked, yo wake up on the shoreline you see swirling  clouds in the distance and all you know is that you must go inland ", 25);
        println("Press ENTER twice to start your adventure");
        enterToContinue();
        clearScreen();

        //Temp
        player.addInventoryItem(new HealthPotionItem());
        player.addInventoryItem(new PointySwordItem());
        player.addInventoryItem(new SnakesFangItem());
        //

        Main.sceneManager.setCurrentScene(new IdleScene(), player);
    }
}
