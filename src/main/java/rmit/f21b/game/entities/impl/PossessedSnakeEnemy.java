package rmit.f21b.game.entities.impl;

import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.impl.SnakesFangItem;
import rmit.f21b.game.item.util.ItemBase;

public class PossessedSnakeEnemy extends Enemy {
    public PossessedSnakeEnemy() {
        super("Possessed Snake", "", 7.5f, 1f);
    }

    @Override
    public ItemBase[] itemsOnDeath() {
        return new ItemBase[]{new SnakesFangItem()};
    }

    @Override
    public String deathItemsDescription() {
        return "You pry the sharp fang out of the snake's gaping mouth. \n +1 Item to inventory";
    }
}
