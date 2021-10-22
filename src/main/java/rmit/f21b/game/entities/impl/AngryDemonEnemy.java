package rmit.f21b.game.entities.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.impl.EndingScene;
import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.util.ItemBase;

public class AngryDemonEnemy extends Enemy {
    public AngryDemonEnemy() {
        super("Angry Demon", "", 10f, 1f);
    }

    @Override
    public ItemBase[] itemsOnDeath() {
        return new ItemBase[]{};
    }

    @Override
    public String deathItemsDescription() {
        return "";
    }

    @Override
    public void onDeath(Player player){
        Main.sceneManager.setCurrentScene(new EndingScene(), player);
    };
}
