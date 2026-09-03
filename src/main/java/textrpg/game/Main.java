package textrpg.game;

import textrpg.game.enums.TextColors;;

public class Main {


    public static void main(String[] args) {
        // Printing text in different colors
        System.out.println(TextColors.RED + "This text is red!" + TextColors.RED);
        System.out.println(TextColors.GREEN + "This text is green!" + TextColors.GREEN);
        System.out.println(TextColors.YELLOW + "This text is yellow!" + TextColors.YELLOW);
        
        // Normal text follows because of ANSI_RESET
        System.out.println(TextColors.RESET + "This is normal text." + TextColors.RESET);
    }
}