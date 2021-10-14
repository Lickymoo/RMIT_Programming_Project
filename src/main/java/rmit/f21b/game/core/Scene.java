package rmit.f21b.game.core;

import rmit.f21b.game.Player;

import java.io.IOException;

public abstract class Scene {
    /**
     * Run whenever the scene is run
     * @param player Player passed through scene
     * @throws IOException
     */
    public abstract void run(Player player) throws IOException;
}
