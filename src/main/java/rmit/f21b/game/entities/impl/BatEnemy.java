package rmit.f21b.game.entities.impl;

import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.impl.SnakesFangItem;
import rmit.f21b.game.item.util.ItemBase;

public class BatEnemy extends Enemy {
    public BatEnemy() {
        super("Bat", "", 5f, .1f);
    }

    @Override
    public ItemBase[] itemsOnDeath() {
        return new ItemBase[]{};
    }

    @Override
    public String deathItemsDescription() {
        return "It was a harmless bat, why did you kill it?";
    }
}
