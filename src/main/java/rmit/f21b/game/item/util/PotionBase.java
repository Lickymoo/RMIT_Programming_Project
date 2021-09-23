package rmit.f21b.game.item.util;

import rmit.f21b.game.Player;

public abstract class PotionBase extends ItemBase{

    public PotionBase(String name, String description) {
        super(name, description);
    }

    public abstract void use(Player player);
}
