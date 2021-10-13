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
        
        println(player.getMapSection().name);
        println(navMan.canMove(player, Cardinal.EAST) + "");
        
        String input = promptText("What direction would you like to go ");
        println("Enter N for North");
        println("Enter S for South");
        println("Enter E for East");
        println("Enter W for West");






        switch (input.toUpperCase()) {
            case "N":
                println("You start moving North ");
                navMan.move(player, 0,-1);
                break;
            case "S":
                println("You start moving South ");
                navMan.move(player, 0, 1);
                break;
            case "E":
                println("You start moving East ");
                navMan.move(player, 1, 0);
                break;
            case "W":
                println("You start moving West ");
                navMan.move(player, -1, 0);
                break;

        }

        println(player.getMapSection().name);








    }







}
