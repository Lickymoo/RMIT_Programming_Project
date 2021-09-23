package rmit.f21b.game.item.util;

public abstract class ArmourBase extends ItemBase{

    public final int health;
    public final float dmgMitigation;

    public ArmourBase(String name, String description, int health, float dmgMitigation) {
        super(name, description);
        this.health = health;
        this.dmgMitigation = dmgMitigation;
    }
}
