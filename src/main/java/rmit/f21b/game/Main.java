package rmit.f21b.game;

import rmit.f21b.game.core.SceneManager;
import rmit.f21b.game.navigation.NavigationManager;

import java.io.IOException;

public class Main {
    public static SceneManager sceneManager = new SceneManager();
    public static NavigationManager navigationManager = new NavigationManager();

    public static final Player player = new Player();

    public static void main(String[] args) throws IOException{
        sceneManager.init(player);

    }
}
