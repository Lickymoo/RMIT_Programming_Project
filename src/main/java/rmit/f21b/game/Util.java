package rmit.f21b.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    /**
    * Shortcut to print to screen
    * @param input input to print to screen
     */
    public static void println(String... input){
        for (String s : input){
            System.out.println(s);
        }
    }

    /**
     * Shortcut to print to screen if conditions are satisfied
     * @param b boolean input which determines whether output is printed
     * @param input input to print to screen
     */
    public static void printif(boolean b, String... input){
        if(!b) return;
        for (String s : input){
            System.out.println(s);
        }
    }

    /**
     * Prints to screen in a type writer effect
     * @param text input to print to screen
     * @param timeMillis time in milliseconds between each character being printed
     */
    public static void typeWriter(String text, long timeMillis){
        for(int i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            try{
                Thread.sleep(timeMillis);//0.5s pause between characters
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Waits for user to press "enter" before continuing
     * @throws IOException
     */
    public static void enterToContinue() throws IOException {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        return;
    }

    /**
     * Prints text to the screen then prompts user to input value
     * @param text input to print to screen
     * @return the input the user has typed in
     */
    public static String promptText(String text){
        println(text);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Prompts user to input value
     * @return the input the user has typed in
     */
    public static String getInput(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Clears the screen
     * @throws IOException
     */
    public static void clearScreen() throws IOException {
        System.out.println(System.lineSeparator().repeat(50));
    }


    /**
     * Formats and displays text as a dialogue box
     * @param input input to be put inside of dialogue box
     */
    public static void displayDialogue(String input){
        //55 wide

        println("+-------------------------------------------------------+");
        println("|                                                       |");
        println(truncateOrFill(55, '|', input));
        println("|                                                       |");
        println("|                               Press ENTER to continue |");
        println("+-------------------------------------------------------+");
    }

    /**
     * Formats text according to line width limitations with inclusion of a border character
     * @param lineSize width constraint of formatting
     * @param border character to be put on both sides after formatting
     * @param input text to be formatted
     * @return
     */
    public static String[] truncateOrFill(int lineSize, char border, String... input){
        List<String> output = new ArrayList<>();

        //iterate over each line
        for(String line : input){
            String[] substrings = line.split("\n");
            for(String subs : substrings){
                String[] words = subs.split(" ");
                StringBuilder builder = new StringBuilder();
                for(String word : words){
                    if(builder.length() + word.length() + 1> lineSize){
                        output.add(border + truncateOrFill(builder.toString().trim(), lineSize) + border);
                        builder.setLength(0);
                        builder.append(word + " ");
                        continue;
                    }
                    builder.append(word + " ");
                }
                output.add(border + truncateOrFill(builder.toString().trim(), lineSize) + border);
            }
        }

        return output.toArray(new String[output.size()]);
    }

    /**
     * Formats text according to line width limitations
     * @param input text to be formatted
     * @param size width constraint of formatting
     * @return
     */
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

    /**
     * Checks whether a string can be parsed to an int
     * @param str input string to be checked
     * @return whether string can be parsed to an int
     */
    public static boolean canParseInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
}
