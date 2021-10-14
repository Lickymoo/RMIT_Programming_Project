package rmit.f21b.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        for(int i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            try{
                Thread.sleep(timeMillis);//0.5s pause between characters
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
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
        println(truncateOrFill(55, '|', input));
        println("|                                                       |");
        println("|                               Press ENTER to continue |");
        println("+-------------------------------------------------------+");
    }

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
