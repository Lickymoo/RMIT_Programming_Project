package rmit.f21b.game;

import rmit.f21b.game.item.impl.ShabbySwordItem;
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
    public static float baseHealth = 10;
    public static float baseDamage = 1;
    public static int maxInventorySize = 6;

    private int playerLocationX = 0;
    private int playerLocationY = 0;


    private float health;

    private List<ItemBase> inventory = new ArrayList<>();

    private WeaponBase equippedWeapon = new ShabbySwordItem();
    private ArmourBase equippedArmour;

    public Player(){
        health = calcMaxHealth();
    }

    public float calcMaxHealth(){
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

    public void setHealth(float value){
        this.health = value;
    }

    public float getHealth(){
        return this.health;
    }

    public float getDamage(){
        return equippedWeapon == null ? baseDamage : equippedWeapon.damage + baseDamage;
    }

    public float getAccuracy(){
        return equippedWeapon == null ? .5f : equippedWeapon.accuracy;
    }

    public int getPlayerLocationX() {return this.playerLocationX;}
    public int getPlayerLocationY() {return this.playerLocationY;}

    public void setPlayerLocationX(int value) {this.playerLocationX = value;}
    public void setPlayerLocationY(int value) {this.playerLocationY = value;}

    public List<ItemBase> getInventory(){
        return this.inventory;
    }

    public boolean addInventoryItem(ItemBase... bases){
        int invSize = inventory.size();
        if(invSize >= maxInventorySize) return false;

        for(ItemBase item : bases){
            inventory.add(item);
        }
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

    public boolean hasItem(Class<? extends ItemBase> clazz){
        for(ItemBase item : this.inventory){
            //checks whether items in inventory share same class as 'clazz'
            if(item.getClass() == clazz)
                return true;
        }
        return false;
    }

    public void tidyInventory(){
        List<ItemBase> newInv = new ArrayList<>();
        for(ItemBase item : this.inventory){
            if(item != null)
                newInv.add(item);
        }
        this.inventory = newInv;
    }

    public boolean removeInventoryItem(ItemBase item){
        return inventory.remove(item);
    }

    public boolean removeInventoryItem(Class<? extends ItemBase> item){
        List<ItemBase> removeList = new ArrayList<>();
        for(ItemBase base : this.inventory){
            if(base.getClass() == item)
                removeList.add(base);
        }

        this.inventory.removeAll(removeList);
        return true;
    }
}
