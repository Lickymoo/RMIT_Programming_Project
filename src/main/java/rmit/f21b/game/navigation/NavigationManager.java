package rmit.f21b.game.navigation;

import rmit.f21b.game.Player;

public class NavigationManager {
    // actual map size
    static final int maxX = 5;
    static final int maxY = 5;

    private final MapSection[][] map = new MapSection[maxX][maxY];

    public NavigationManager() {
        //Initialize map areas
        MapSection shipWreck = new MapSection("The Shipwreck","A grim coastline lined with broken ship parts and dangerous animals.");
        MapSection theShore = new MapSection("The Shore","The beach's shore, crusty and dark.", (p, a) -> {if(!a.visited) System.out.println("first");});
        MapSection alvineForest = new MapSection("The Alvine Forest","A thick plumage of leaves and towering oak trees surround you.");
        MapSection hauntedPyramid = new MapSection("The Haunted Pyramid","An ancient ruin, still inhabited by those once living.");
        MapSection villageCaldwelle = new MapSection("The Village of Caldwelle","A poor village in the middle of desolation, teaming with civilization.");
        MapSection caldwelleSwamp  = new MapSection("The Caldwelle Swamp","A dark, cold marshland. \nCreatures lurk beneath the murky depths.");
        MapSection desertPlains = new MapSection("The Desert Plains","A vast stretch of lifeless sand.");
        MapSection melancholyCave = new MapSection("The Melancholy Cave Entrance","The mouth of a dark gloomy cave beckons you to enter.");
        MapSection mountainCliffsAscent = new MapSection("The Mountain Cliffs Ascent","A tall ascent towards the peak of a mountain, shear cliff faces ahead of you.");
        MapSection mountainCrux = new MapSection("The Mountain Crux","The crux of the mountain's ascent.");

        map[0][0] = shipWreck;
        map[0][1] = theShore;
        map[1][0] = alvineForest;
        map[1][2] = hauntedPyramid;
        map[2][0] = villageCaldwelle;
        map[2][1] = caldwelleSwamp;
        map[2][2] = desertPlains;
        map[2][3] = melancholyCave;
        map[2][4] = melancholyCave;
        map[3][3] = mountainCliffsAscent;
        map[4][3] = mountainCrux;
    }

    public void move(Player player, Cardinal direction){
        int currentY = player.getPlayerLocationY();
        int currentX = player.getPlayerLocationX();
        player.setPlayerLocationY(currentY + direction.y);
        player.setPlayerLocationX(currentX + direction.x);
    }

    public boolean canMove(Player player, Cardinal direction){
        int x = player.getPlayerLocationX();
        int y = player.getPlayerLocationY();
        x += direction.x;
        y += direction.y;

        if(x < 0 || y < 0 || x >= maxX || y >= maxY)
            return false;

        if(map[x][y] == null)
            return false;

        return true;
    }

    public MapSection getNeighbourSection(Player player, Cardinal direction) {
        int x = player.getPlayerLocationX();
        int y = player.getPlayerLocationY();
        x += direction.x;
        y += direction.y;
        return map [x] [y];
    }

    public MapSection[][] getMap(){
        return this.map;
    }






}
