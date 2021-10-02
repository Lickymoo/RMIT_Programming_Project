package rmit.f21b.game.navigation;

import rmit.f21b.game.Player;

public class NavigationMan {
    // actual map size
    static final int maxX = 5;
    static final int maxY = 5;

    private MapSection[][] map = new MapSection[maxX][maxY];

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

    public boolean canMove(int x, int y){
        if(x < 0 || y < 0 || x >= maxX || y >= maxY)
            return false;

        if(map[x][y] == null)
            return false;

        return true;
    }




}
