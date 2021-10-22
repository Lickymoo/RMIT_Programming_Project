package rmit.f21b.game.item.util;

import rmit.f21b.game.Player;

public abstract class PotionBase extends ItemBase{

    public final int healValue;
    public PotionBase(String name, String description, int healValue) {
        super(name, description);
        this.healValue = healValue;
    }

    public abstract void use(Player player);
}
