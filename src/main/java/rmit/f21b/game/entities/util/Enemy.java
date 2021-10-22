package rmit.f21b.game.entities.util;

import rmit.f21b.game.Player;
import rmit.f21b.game.item.util.ItemBase;

public abstract class Enemy {
    public final String name;
    public final String description;

    public final float maxHealth;
    public float health;

    public final float damage;

    public Enemy(String name, String description, float maxHealth, float damage){
        this.name = name;
        this.description = description;
        this.maxHealth = maxHealth;
        this.damage = damage;

        //Spawn them with max health
        this.health = maxHealth;
    }

    public abstract ItemBase[] itemsOnDeath();

    public abstract String deathItemsDescription();

    public void onDeath(Player player){};

}
