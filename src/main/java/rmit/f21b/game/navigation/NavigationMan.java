package rmit.f21b.game.navigation;

import rmit.f21b.game.Player;

public class NavigationMan {
        // actual map size
    MapSection [] [] map = new MapSection [5] [5];

    public void moveNorth(Player player){
        int y = player.getPlayerLocationY();
            player.setPlayerLocationY(y+1);

    }

    public void moveSouth(Player player){
        int y = player.getPlayerLocationY();
        player.setPlayerLocationY(y-1);

    }

    public void moveEast(Player player){
        int x = player.getPlayerLocationX();
        player.setPlayerLocationX(x+1);

    }

    public void moveWest(Player player){
        int x = player.getPlayerLocationX();
        player.setPlayerLocationY(x-1);

    }







}
