package rmit.f21b.game.item.impl;

import rmit.f21b.game.Player;
import rmit.f21b.game.item.util.PotionBase;

public class HealthPotionItem extends PotionBase {
    public HealthPotionItem() {
        super("Health Potion", "A red potion, restores 5 health on use.");
    }

    @Override
    public void use(Player player) {
        int playerHealth = player.getHealth();
        player.setHealth(playerHealth + 5);
    }
}
