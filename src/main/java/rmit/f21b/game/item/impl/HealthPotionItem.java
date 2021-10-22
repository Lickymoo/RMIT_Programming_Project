package rmit.f21b.game.item.impl;

import rmit.f21b.game.Player;
import rmit.f21b.game.item.util.PotionBase;

public class HealthPotionItem extends PotionBase {
    public HealthPotionItem() {
        super("Health Potion", "A red potion, restores 5 health on use.", 5);
    }

    @Override
    public void use(Player player) {
        float playerHealth = player.getHealth();
        player.setHealth(playerHealth + this.healValue);
    }
}
