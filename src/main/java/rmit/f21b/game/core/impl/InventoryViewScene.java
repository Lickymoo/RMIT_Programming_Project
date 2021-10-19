package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.item.util.*;

import java.io.IOException;
import java.util.List;

import static rmit.f21b.game.Util.*;

public class InventoryViewScene extends Scene {

    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        List<ItemBase> inventory = player.getInventory();
        println("Equipped Armour: " + (player.getEquippedArmour() != null ? player.getEquippedArmour().name : "None"));
        println("Equipped Weapon: " + (player.getEquippedWeapon() != null ? player.getEquippedWeapon().name : "None"));
        println("");

        if(inventory.size() == 0){
            println("Your inventory is empty");
            println("ENTER to continue");
            enterToContinue();
            Main.sceneManager.setCurrentScene(new IdleScene(), player);
        }
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i) == null) continue;
            println(i + " - " + inventory.get(i).name);
        }

        String input = promptText("Enter item number to interact or type \"EXIT\" to return");
        if(input.equalsIgnoreCase("exit")){
            Main.sceneManager.setCurrentScene(new IdleScene(), player);
        }
        if(!canParseInt(input)){
            println("Incorrect input \'" + input + "\'");
            println("ENTER to continue");
            enterToContinue();
            Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
        }
        int index = Integer.parseInt(input);
        if(index < 0 || index >= inventory.size()){
            println("There is no item here");
            println("ENTER to continue");
            enterToContinue();
            Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
        }
        ItemBase base = inventory.get(index);
        if(base == null){
            println("There is no item here");
            println("ENTER to continue");
            enterToContinue();
            Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
        }

        clearScreen();
        println(base.name, base.description);
        println(base.displayStats());
        println("");
        println("Enter the following keys:");
        printif(!(base instanceof QuestItem), "D - Drop");
        printif((base instanceof EquippableItem), "E - Equip");
        println("EXIT - Exit back to inventory view");
        println();

        String interactInput = getInput();
        switch (interactInput.toUpperCase()){
            case "D":
                if(base instanceof QuestItem){
                    println("This is a quest item, it cannot be dropped.");
                    println("ENTER to continue");
                    enterToContinue();
                    Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
                }
                player.removeInventoryItem(base);
                println("Item dropped");
                break;
            case "E":
                if(!(base instanceof EquippableItem)){
                    println("This item is not able to be equipped");
                    println("ENTER to continue");
                    enterToContinue();
                    Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
                    return;
                }
                player.removeInventoryItem(base);
                player.equipItem((EquippableItem) base);
                println("Item equipped!");
                
                break;
            case "EXIT":
                Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
                break;
            default:
                println("Incorrect input \'" + interactInput + "\'");
                println("Press ENTER to continue");
                enterToContinue();
                Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
                break;
        }

        Main.sceneManager.setCurrentScene(new InventoryViewScene(), player);
    }

}
