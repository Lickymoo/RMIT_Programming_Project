package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.navigation.MapSection;

import java.io.IOException;

import static rmit.f21b.game.Util.*;

public class IdleScene extends Scene {
    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        MapSection section = player.getMapSection();

        println("Current Location: " + player.getMapSection().name);
        println(" ");
        println("Enter a key to continue: ");
        println("I - Open inventory");
        println("M - Move to another location");
        println("O - View map");
        printif(section.npc != null, "N - Interact with NPC");
        String input = getInput();
        switch (input.toUpperCase()){
            case "I":
                Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
                break;
            case "M":
                Main.sceneManager.setCurrentScene(new MovementScene(), player);
                break;
            case "O":
                Main.sceneManager.setCurrentScene(new MapViewScene(), player);
                break;
            case "N":
                if(section.npc == null){
                    println("There is no NPC in this area.");
                    println("Press ENTER to continue");
                    enterToContinue();
                    Main.sceneManager.setCurrentScene(new IdleScene(), player);
                }
                section.npc.interact(player);
                break;
            default:
                println("Invalid input");
                println("Press ENTER to continue");
                enterToContinue();
                Main.sceneManager.setCurrentScene(new IdleScene(), player);
                break;
        }

    }
}
