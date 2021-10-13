package rmit.f21b.game;

import rmit.f21b.game.item.util.ArmourBase;
import rmit.f21b.game.item.util.ItemBase;
import rmit.f21b.game.item.util.WeaponBase;
import rmit.f21b.game.navigation.MapSection;
import rmit.f21b.game.navigation.NavigationManager;


public class Player {
    public static int baseHealth = 10;
    public static int baseDamage = 1;
    private int playerLocationX = 0;
    private int playerLocationY = 0;


    private int health;

    private ItemBase[] inventory = new ItemBase[6];

    private WeaponBase equippedWeapon;
    private ArmourBase equippedArmour;

    public int calcMaxHealth(){
        int armourHealth = equippedArmour == null ? 0 : equippedArmour.health;
        return baseHealth + armourHealth;
    }

    public MapSection getMapSection(){
        NavigationManager navMan = Main.navigationManager;
        return navMan.getMap()[playerLocationX][playerLocationY];
    }

    //Getter Setters
    public void setHealth(int value){
        this.health = value;
    }

    public int getHealth(){
        return this.health;
    }

    public int getPlayerLocationX() {return this.playerLocationX;}
    public int getPlayerLocationY() {return this.playerLocationY;}

    public void setPlayerLocationX(int value) {this.playerLocationX = value;}
    public void setPlayerLocationY(int value) {this.playerLocationY = value;}
}
