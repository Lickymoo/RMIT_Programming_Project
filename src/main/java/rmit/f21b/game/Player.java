package rmit.f21b.game;

import rmit.f21b.game.item.util.ArmourBase;
import rmit.f21b.game.item.util.EquippableItem;
import rmit.f21b.game.item.util.ItemBase;
import rmit.f21b.game.item.util.WeaponBase;
import rmit.f21b.game.navigation.MapSection;
import rmit.f21b.game.navigation.NavigationManager;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class Player {
    public static int baseHealth = 10;
    public static int baseDamage = 1;
    public static int maxInventorySize = 6;

    private int playerLocationX = 0;
    private int playerLocationY = 0;


    private int health;

    private final List<ItemBase> inventory = new ArrayList<>();

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
    public WeaponBase getEquippedWeapon(){
        return this.equippedWeapon;
    }

    public void equipItem(EquippableItem item){
        if(item instanceof WeaponBase){
            addInventoryItem(equippedWeapon);
            this.equippedWeapon = (WeaponBase) item;

        }
        if(item instanceof ArmourBase){
            addInventoryItem(equippedArmour);
            this.equippedArmour = (ArmourBase) item;
        }
    }

    public ArmourBase getEquippedArmour(){
        return this.equippedArmour;
    }

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

    public List<ItemBase> getInventory(){
        return this.inventory;
    }

    public boolean addInventoryItem(ItemBase base){
        int invSize = inventory.size();
        if(invSize >= maxInventorySize) return false;

        inventory.add(base);
        return true;
    }

    public ItemBase getInventoryItem(int index){
        return inventory.get(index);
    }

    public boolean removeInventoryItem(int index){
        if(inventory.size() < index) return false;
        inventory.remove(index);
        return true;
    }


    public boolean removeInventoryItem(ItemBase item){
        return inventory.remove(item);
    }
}
