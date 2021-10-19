package rmit.f21b.game.navigation;

public enum Cardinal {
    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);

    public final int x,y;

    Cardinal(int x, int y){
        this.x = x;
        this.y = y;
    }
}
