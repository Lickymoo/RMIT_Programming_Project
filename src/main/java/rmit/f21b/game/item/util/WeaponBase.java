package rmit.f21b.game.item.util;

public abstract class WeaponBase extends ItemBase implements EquippableItem{

    public final int damage;
    public final float accuracy;

    public WeaponBase(String name, String description, int damage, float accuracy) {
        super(name, description);
        this.damage = damage;
        this.accuracy = accuracy;
    }

    @Override
    public String[] displayStats(){
        return new String[]{"Damage: " + damage, "Accuracy: " + accuracy};
    }
}
