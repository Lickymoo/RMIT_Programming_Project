package rmit.f21b.game.navigation;

import rmit.f21b.game.Player;
import rmit.f21b.game.entities.util.NPC;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MapSection {

    public final String name;
    public final String description;
    public BiConsumer<Player, MapSection> enterEvent;
    public boolean visited = false;

    public NPC npc;

    public MapSection(String name,String description){
        this.name = name;
        this.description = description;
    }

    public MapSection(String name,String description, NPC npc){
        this.name = name;
        this.description = description;
        this.npc = npc;
    }

    public MapSection(String name,String description, BiConsumer<Player, MapSection> enterEvent){
        this.name = name;
        this.description = description;
        this.enterEvent = enterEvent;
    }

    public void onEnter(Player player){
        if(enterEvent != null)
            enterEvent.accept(player, this);
    }
}
