package rmit.f21b.game.core;

import rmit.f21b.game.Player;

import java.io.IOException;

public abstract class Scene {
    public abstract void run(Player player) throws IOException;
}
