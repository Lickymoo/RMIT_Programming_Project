package rmit.f21b.game.item.util;

public abstract class ArmourBase extends ItemBase implements EquippableItem{

    public final int health;
    public final float dmgMitigation;

    public ArmourBase(String name, String description, int health, float dmgMitigation) {
        super(name, description);
        this.health = health;
        this.dmgMitigation = dmgMitigation;
    }

    @Override
    public String[] displayStats(){
        return new String[]{"Health: " + health, "Damage Mitigation: " + dmgMitigation};
    }
}
