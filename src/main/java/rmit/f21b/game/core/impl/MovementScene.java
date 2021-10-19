package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.navigation.Cardinal;
import rmit.f21b.game.navigation.NavigationManager;

import static rmit.f21b.game.Util.*;

import java.io.IOException;

import static rmit.f21b.game.Util.*;

public class MovementScene extends Scene {

    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        NavigationManager navMan = Main.navigationManager;
        MapViewScene.renderMap(player);


        if (navMan.canMove(player, Cardinal.NORTH))
            println("N - Move North");
        if (navMan.canMove(player, Cardinal.SOUTH))
            println("S - Move South");
        if (navMan.canMove(player, Cardinal.EAST))
            println("E - Move East");
        if (navMan.canMove(player, Cardinal.WEST))
            println("W - Move West");

        println("EXIT - To return");
        String input = promptText("What direction would you like to go ");

        switch (input.toUpperCase()) {
            case "N":
                if (!navMan.canMove(player, Cardinal.NORTH)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                navMan.move(player, Cardinal.NORTH);
                break;
            case "S":
                if (!navMan.canMove(player, Cardinal.SOUTH)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                navMan.move(player, Cardinal.SOUTH);
                break;
            case "E":
                if (!navMan.canMove(player, Cardinal.EAST)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                navMan.move(player, Cardinal.EAST);
                break;
            case "W":
                if (!navMan.canMove(player, Cardinal.WEST)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                navMan.move(player, Cardinal.WEST);
                break;
            case "EXIT":
                Main.sceneManager.setCurrentScene(new IdleScene(), player);
                break;
            default:
                println("Incorrect input \'" + input + "\'");
                println("Press ENTER to continue");
                Main.sceneManager.setCurrentScene(new MovementScene(), player);
                break;
        }
        Main.sceneManager.setCurrentScene(new EnteredAreaScene(), player);
    }
}
