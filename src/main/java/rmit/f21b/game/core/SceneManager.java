package rmit.f21b.game.core;

import rmit.f21b.game.Player;
import rmit.f21b.game.core.impl.IdleScene;
import rmit.f21b.game.core.impl.IntroScene;

import java.io.IOException;

public class SceneManager {
    public Scene currentScene = new IntroScene();

    public void init(Player player) throws IOException {
        currentScene.run(player);
    }

    public void setCurrentScene(Scene scene, Player player) throws IOException{
        this.currentScene = scene;
        currentScene.run(player);
    }

}
