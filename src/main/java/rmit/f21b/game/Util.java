package rmit.f21b.game;

import java.io.IOException;
import java.util.Scanner;

public class Util {
    public static void println(String... input){
        for (String s : input){
            System.out.println(s);
        }
    }

    public static void printif(boolean b, String... input){
        if(!b) return;
        for (String s : input){
            System.out.println(s);
        }
    }

    public static void typeWriter(String text, long timeMillis){
        try {
            String[] chars = text.split("");
            for (String c : chars) {
                System.out.print(c);
                Thread.sleep(timeMillis);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void enterToContinue() throws IOException {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        return;
    }

    public static String promptText(String text){
        println(text);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
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

    public static boolean canParseInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
}
