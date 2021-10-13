package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.core.impl.inventory.InventoryViewScene;

import java.io.IOException;

import static rmit.f21b.game.Util.promptText;

public class IdleScene extends Scene {
    @Override
    public void run(Player player) throws IOException {
        Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);

    }
}
