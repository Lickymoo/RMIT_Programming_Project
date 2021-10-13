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
        NavigationManager navMan = Main.navigationManager;



        if (navMan.canMove(player, Cardinal.NORTH))
            println("Enter N for North");
        if (navMan.canMove(player, Cardinal.SOUTH))
            println("Enter S for South");
        if (navMan.canMove(player, Cardinal.EAST))
            println("Enter E for East");
        if (navMan.canMove(player, Cardinal.WEST))
            println("Enter W for West");

        String input = promptText("What direction would you like to go ");

        switch (input.toUpperCase()) {
            case "N":
                if (!navMan.canMove(player, Cardinal.NORTH)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                println("You start moving North towards " + navMan.getNeighbourSection(player, Cardinal.NORTH).name);
                navMan.move(player, 0,-1);
                break;
            case "S":
                if (!navMan.canMove(player, Cardinal.SOUTH)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                println("You start moving South towards" + navMan.getNeighbourSection(player, Cardinal.SOUTH).name);
                navMan.move(player, 0, 1);
                break;
            case "E":
                if (!navMan.canMove(player, Cardinal.EAST)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                println("You start moving East towards" + navMan.getNeighbourSection(player, Cardinal.EAST).name);
                navMan.move(player, 1, 0);
                break;
            case "W":
                if (!navMan.canMove(player, Cardinal.WEST)){
                    println("you can not go that way please choose another direction");
                    Main.sceneManager.setCurrentScene(new MovementScene(), player);
                }
                println("You start moving West towards" + navMan.getNeighbourSection(player, Cardinal.WEST).name);
                navMan.move(player, -1, 0);
                break;
            default:
                println("incorrect input");
                Main.sceneManager.setCurrentScene(new MovementScene(), player);
                break;
        }
        Main.sceneManager.setCurrentScene(new IdleScene(), player);
    }
}
