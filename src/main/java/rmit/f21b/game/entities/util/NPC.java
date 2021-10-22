package rmit.f21b.game.entities.util;

import rmit.f21b.game.Player;
import rmit.f21b.game.item.util.ItemBase;

import java.io.IOException;

public abstract class NPC {
    public final String name;
    public final String description;

    public NPC(String name, String description){
        this.name = name;
        this.description = description;
    }

    public abstract void interact(Player player) throws IOException;
}
