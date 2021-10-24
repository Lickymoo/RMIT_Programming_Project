package rmit.f21b.game.entities.impl;

import rmit.f21b.game.Main;
import rmit.f21b.game.Player;
import rmit.f21b.game.core.impl.IdleScene;
import rmit.f21b.game.entities.util.NPC;
import rmit.f21b.game.item.impl.HealthPotionItem;
import rmit.f21b.game.item.impl.SnakesFangItem;

import java.io.IOException;

import static rmit.f21b.game.Util.*;

public class GeorgeNPC extends NPC {

    private boolean visited = false;
    private boolean questComplete = false;

    public GeorgeNPC() {
        super("George", "An old man");
    }

    @Override
    public void interact(Player player) throws IOException {
        clearScreen();
        if(!visited){
            displayDialogue("An old man approaches you, introducing himself");
            enterToContinue();
            clearScreen();

            displayDialogue("Hello traveller! \n I am George, the local fixer.");
            enterToContinue();
            clearScreen();

            displayDialogue("I am truly surprised you've managed to stay alive after that shipwreck.");
            enterToContinue();
            clearScreen();

            displayDialogue("I'm sure you've noticed the grimness of our situation.");
            enterToContinue();
            clearScreen();

            displayDialogue("An evil demon inhabits the mountain, reigning terror upon us.");
            enterToContinue();
            clearScreen();

            displayDialogue("Seeing as you have come this far, I believe you have the power to defeat this demon");
            enterToContinue();
            clearScreen();

            displayDialogue("I may even have some supplies for you. \n However, I require you to do something for me before I give them to you.");
            enterToContinue();
            clearScreen();

            displayDialogue("Not too far from here, there is a great pyramid. \n An evil snake possessed by the demon inhabits it. You must retrieve it's fang and return it to me.");
            enterToContinue();

            visited = true;
            Main.sceneManager.setCurrentScene(new IdleScene(), player);
        }
        if(player.hasItem(SnakesFangItem.class)){
            questComplete = true;
            player.removeInventoryItem(SnakesFangItem.class);
            player.addInventoryItem(new HealthPotionItem());
        }

        if(!questComplete){
            displayDialogue("Have you gotten that snake's fang yet? \n Head East of here and look for the pyramid.");
            enterToContinue();
        }else{
            displayDialogue("Thanks for getting that snake's fang. \n Good luck with the demon!");
            enterToContinue();
        }
        Main.sceneManager.setCurrentScene(new IdleScene(), player);


    }
}
