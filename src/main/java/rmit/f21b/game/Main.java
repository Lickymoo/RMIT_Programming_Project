package rmit.f21b.game;

import java.io.IOException;
import java.util.Scanner;

import static rmit.f21b.game.Util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        clearScreen();
        println(
        "██████╗ ██████╗  ██████╗",
        "██╔══██╗██╔══██╗██╔════╝",
        "██████╔╝██████╔╝██║  ███╗",
        "██╔══██╗██╔═══╝ ██║   ██║",
        "██║  ██║██║     ╚██████╔╝",
        "╚═╝  ╚═╝╚═╝      ╚═════╝ ");
        println("");
        println("Press ENTER to start your adventure");
        println("");
        enterToContinue();
        clearScreen();

        promptDialogue("This is a dialogue");
        enterToContinue();
        clearScreen();

        println("ttt");
    }
}
