package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import static rmit.f21b.game.Util.*;

import java.io.IOException;

import static rmit.f21b.game.Util.*;

public class MovementScene extends Scene {

    @Override
    public void run(Player player) throws IOException {
        println(player.getMapSection().name);
        String input = promptText("What direction would you like to go (N) (S) (E) (W)");


        switch (input.toUpperCase()) {
            case "N":
                println("You start moving North ");
                Main.navigationManager.move(player, 0,1);
                break;
            case "S":
                println("You start moving South ");
                Main.navigationManager.move(player, 0, -1);
                break;
            case "E":
                println("You start moving East ");
                Main.navigationManager.move(player, 1, 0);
                break;
            case "W":
                println("You start moving West ");
                Main.navigationManager.move(player, -1, 0);
                break;

        }

        println(player.getMapSection().name);








    }







}
