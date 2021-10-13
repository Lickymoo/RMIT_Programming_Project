package rmit.f21b.game.item.util;

public abstract class ItemBase {
    public final String name;
    public final String description;

    public ItemBase(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String[] displayStats(){
        return new String[]{};
    }
}

