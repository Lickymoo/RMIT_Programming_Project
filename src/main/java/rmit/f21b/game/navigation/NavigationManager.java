package rmit.f21b.game.navigation;

import rmit.f21b.game.Player;

public class NavigationManager {
    // actual map size
    static final int maxX = 5;
    static final int maxY = 5;


    private MapSection[][] map = new MapSection[maxX][maxY];

    public NavigationManager() {
        MapSection shipWreck = new MapSection("ShipWreck","Starting zone");
        MapSection theShore = new MapSection("The Shore","Shoreline");
        MapSection alvineForest = new MapSection("The Alvine Forest","forest");
        MapSection hauntedPyramid = new MapSection("Haunted Pyramid","pyramid");
        MapSection villageCaldwelle = new MapSection("village of Caldwelle","village");
        MapSection caldwelleSwamp  = new MapSection("Caldwelle Swamp","Swamp");
        MapSection desertPlains = new MapSection("Desert Plains","Desert");
        MapSection melancholyCave = new MapSection("Melancholy Cave Entrance","Cave");
        MapSection mountainCliffsAscent = new MapSection("Mountain Cliffs Ascent","Mountain");
        MapSection mountainCrux = new MapSection("Mountain Crux","Mountain crux");

        map[0][0] = shipWreck;
        map[0][1] = theShore;
        map[1][0] = alvineForest;
        map[1][1] = hauntedPyramid;
        map[2][0] = villageCaldwelle;
        map[2][1] = caldwelleSwamp;
        map[2][2] = desertPlains;
        map[3][2] = melancholyCave;
        map[4][2] = melancholyCave;
        map[3][3] = mountainCliffsAscent;
        map[3][4] = mountainCrux;
    }


    public void move(Player player, int x, int y){
        int currentY = player.getPlayerLocationY();
        int currentX = player.getPlayerLocationX();
        player.setPlayerLocationY(currentY + y);
        player.setPlayerLocationX(currentX + x);
    }


    public boolean canMove(int x, int y){
        if(x < 0 || y < 0 || x >= maxX || y >= maxY)
            return false;

        if(map[x][y] == null)
            return false;

        return true;
    }






}
