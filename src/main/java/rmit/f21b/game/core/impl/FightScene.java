package rmit.f21b.game.core.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.Util;
import rmit.f21b.game.core.Scene;
import rmit.f21b.game.entities.util.Enemy;
import rmit.f21b.game.item.impl.HealthPotionItem;

import java.io.IOException;

import static rmit.f21b.game.Util.*;

public class FightScene extends Scene {

    private final Enemy enemy;
    private boolean playersTurn = true;

    public FightScene(Enemy enemy){
        super();
        this.enemy = enemy;
    }

    @Override
    public void run(Player player) throws IOException {
        clearScreen();
        println("A " + enemy.name + " blocks your path, you must fight it.");
        println("Press ENTER to continue");
        enterToContinue();
        while  (enemy.health > 0){
            clearScreen();
            if(playersTurn){
                println("Health: " + player.getHealth() + "/" + player.calcMaxHealth());
                println(enemy.name + "'s Health: " + enemy.health + "/" + enemy.maxHealth);
                println("");
                println("S - Skip turn");
                println("A - Attack");
                printif(player.hasItem(HealthPotionItem.class), "H - Use heal potion");

                String input = getInput();

                switch (input.toUpperCase()){
                    case "S":
                        playersTurn = !playersTurn;
                        continue;
                    case "A":
                        int random = Util.random(0, 100);
                        float perc = (player.getAccuracy()/1f) * 100f;
                        float damage = player.getDamage();

                        clearScreen();
                        if(random <= perc){
                            println("You have hit " + enemy.name + " for " + damage + " damage");
                            enemy.health -= damage;
                        }else{
                            println("Your attack has missed!");
                        }
                        println("Press ENTER to continue");
                        enterToContinue();

                        break;
                    case "H":
                        if(!player.hasItem(HealthPotionItem.class)){
                            println("You do not have any health potions in your inventory.");
                            println("Press ENTER to continue");
                            enterToContinue();
                            continue;
                        }
                        int heal = new HealthPotionItem().healValue;
                        player.setHealth(Math.min(player.getHealth() + heal, player.calcMaxHealth()));
                        player.removeInventoryItem(HealthPotionItem.class);
                        println("You have healed for " + heal + " health.");
                        println("Press ENTER to continue");
                        enterToContinue();

                        break;
                    default:
                        println("Invalid input");
                        println("Press ENTER to continue");
                        enterToContinue();
                        continue;
                }
            }else{
                println(enemy.name + " attacks you dealing " + enemy.damage + " damage.");
                player.setHealth(player.getHealth() - enemy.damage);
                println("Press ENTER to continue");
                enterToContinue();
            }
            playersTurn = !playersTurn;

            if(player.getHealth() <= 0){
                Main.sceneManager.setCurrentScene(new PlayerDeathScene(), player);
            }
        }

        player.addInventoryItem(enemy.itemsOnDeath());
        player.getMapSection().visited = true;
        enemy.onDeath(player);
        Main.sceneManager.setCurrentScene(new EnemyKilledScene(enemy), player);
    }
}
























