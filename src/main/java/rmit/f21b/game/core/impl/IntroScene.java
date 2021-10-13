package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;

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

        println("Press ENTER to start your adventure");
        println("");
        enterToContinue();
        clearScreen();

        promptDialogue("This is a dialogue");
        enterToContinue();
        clearScreen();
        Main.sceneManager.setCurrentScene(new MovementScene(), player);
    }
}
