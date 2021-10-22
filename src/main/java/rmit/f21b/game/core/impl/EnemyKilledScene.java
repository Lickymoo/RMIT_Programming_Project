package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.util.ItemBase;

import java.io.IOException;

import static rmit.f21b.game.Util.*;


public class EnemyKilledScene extends Scene {

    private final Enemy enemy;

    public EnemyKilledScene(Enemy enemy){
        this.enemy = enemy;
    }

    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        ItemBase[] drops = enemy.itemsOnDeath();

        displayDialogue("You have slain the " + enemy.name + "\n \n" + enemy.deathItemsDescription() );
        enterToContinue();

        player.getMapSection().onEnter(player);

        Main.sceneManager.setCurrentScene(new IdleScene(), player);
    }
}
