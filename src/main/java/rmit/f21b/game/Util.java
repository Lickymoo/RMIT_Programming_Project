package rmit.f21b.game;

import java.io.IOException;
import java.util.Scanner;

public class Util {
    public static void println(String... input){
        for (String s : input){
            System.out.println(s);
        }
    }

    public static void enterToContinue() throws IOException {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        return;
    }

    public static void clearScreen() throws IOException {
        System.out.println(System.lineSeparator().repeat(50));
    }

    public static void promptDialogue(String input){
        //55 wide

        println("+-------------------------------------------------------+");
        println("|                                                       |");
        println("| "+ truncateOrFill(input, 54) + "|");
        println("|                                                       |");
        println("|                               Press ENTER to continue |");
        println("+-------------------------------------------------------+");
    }

    public static String truncateOrFill(String input, int size){
        if(input.length() > size){
            StringBuilder sb = new StringBuilder();
            sb.append(input);
            sb.setLength(size);
            return sb.toString();
        }
        if(input.length() < size) {
            StringBuilder sb = new StringBuilder();
            sb.append(input);
            int diff = size - input.length();
            for (int i = 0; i < diff; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        return input;
    }
}
