package rmit.f21b.game;

import rmit.f21b.game.item.util.ArmourBase;
import rmit.f21b.game.item.util.ItemBase;
import rmit.f21b.game.item.util.WeaponBase;

public class Player {
    public static int baseHealth = 10;
    public static int baseDamage = 1;

    private int health;

    private ItemBase[] inventory = new ItemBase[6];

    private WeaponBase equippedWeapon;
    private ArmourBase equippedArmour;

    public int calcMaxHealth(){
        int armourHealth = equippedArmour == null ? 0 : equippedArmour.health;
        return baseHealth + armourHealth;
    }

    //Getter Setters
    public void setHealth(int value){
        this.health = value;
    }

    public int getHealth(){
        return this.health;
    }
}
