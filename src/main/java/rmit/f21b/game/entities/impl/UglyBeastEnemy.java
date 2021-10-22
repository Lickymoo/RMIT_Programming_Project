package rmit.f21b.game.entities.impl;

import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.impl.PointySwordItem;
import rmit.f21b.game.item.util.ItemBase;

public class UglyBeastEnemy extends Enemy {
    public UglyBeastEnemy() {
        super("Ugly Beast", "", 5f, .75f);
    }

    @Override
    public ItemBase[] itemsOnDeath() {
        return new ItemBase[]{new PointySwordItem()};
    }

    @Override
    public String deathItemsDescription() {
        return "The ugly beast spews out a large, pointy sword. \n +1 Item to inventory";
    }
}
