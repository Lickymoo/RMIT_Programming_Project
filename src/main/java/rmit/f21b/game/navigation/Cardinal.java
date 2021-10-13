package rmit.f21b.game.navigation;

public enum Cardinal {
    NORTH(0, -1),
    SOUTH(0, 1),
    EAST(1, 0),
    WEST(-1, 0);

    public final int x,y;

    Cardinal(int x, int y){
        this.x = x;
        this.y = y;
    }
}
