package rmit.f21b.game.entities.impl;

import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.impl.MonstrousCrabShellItem;
import rmit.f21b.game.item.util.ItemBase;

public class MonstrousCrabEnemy extends Enemy {
    public MonstrousCrabEnemy() {
        super("Monstrous Crab", "Towering behemoth", 5, .5f);
    }

    @Override
    public ItemBase[] itemsOnDeath() {
        return new ItemBase[]{new MonstrousCrabShellItem()};
    }

    @Override
    public String deathItemsDescription() {
        return "You manage to fashion the monster's carcass into a make-shift armour piece. \n +1 Item to inventory";
    }
}
