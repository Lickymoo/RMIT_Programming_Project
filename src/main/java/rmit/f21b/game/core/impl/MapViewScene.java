package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.navigation.MapSection;
import rmit.f21b.game.navigation.NavigationManager;

import java.io.IOException;

import static rmit.f21b.game.Util.*;


public class MapViewScene extends Scene {
    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        NavigationManager navMan = Main.navigationManager;
        MapSection[][] map = navMan.getMap();
        String[][] displayMap = new String[map.length*2-1][map[0].length*4-3];
        populateStringArray(" ", displayMap);

        for(int y = 0; y < map[0].length; y++){
            for(int x = 0; x < map.length; x++){
                //draw areas
                displayMap[x*2][y*4] = map[x][y] == null ? " " : (map[x][y] == player.getMapSection() ? "O" : "#");

                //draw connections X axis
                if(map[0].length > y+1 && map[x][y] != null)
                    displayMap[x*2][y*4+2] = map[x][y+1] == null ? " " : "-";

                //draw connections Y axis
                if(map.length > x+1 && map[x][y] != null)
                    displayMap[x*2+1][y*4] = map[x+1][y] == null ? " " : "|";
            }
        }
        //display map
        println("Map view");
        println("+-------------------+");
        for(int x = 0; x < displayMap.length; x++){
            print("| ");
            for(int y = 0; y < displayMap[x].length; y++){
                print(displayMap[x][y]);
            }
            println(" |");
        }
        println("+-------------------+");
        println("Legend: ", "# = Area", "- = Connection between area", "O = You are currently here", "");
        /*
       +-------------------+
       | # - #             |
       | |                 |
       | #       #         |
       | |       |         |
       | # - # - # - # - # |
       |             |     |
       |             #     |
       |             |     |
       |             #     |
       +-------------------+
        */

        /*
        for(int y = 0; y < map[0].length; y++){
            for(int x = 0; x < map.length; x++){
                if(map[x][y] != null)
                println(x + ", " + y + ": " + map[x][y].name);
            }
        }
         */

        println("Press ENTER to continue");
        enterToContinue();

        Main.sceneManager.setCurrentScene(new IdleScene(), player);
    }


    private void populateStringArray(String filler, String[][] map){
        for(int x = 0; x < map.length; x++){
            for(int y = 0; y < map[x].length; y++){
                map[x][y] = filler;
            }
        }
    }
}
