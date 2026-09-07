package textrpg.game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import textrpg.game.enums.TextColors;

public interface Gameplay {
    // COMBAT
    public default void playCombat(Player player, Enemy enemy){
        Scanner input = new Scanner(System.in);
  
        while(!isPlayerDead(player) && !isEnemyDefeated(enemy)){
            System.out.println("Commands: KICK, PUNCH, POWER, WEAPON");
            String attackString = input.nextLine().toUpperCase();
            player.attack(attackString);

            if(!isEnemyDefeated(enemy)){
                enemy.attack(player);
            }
        }

        if(isPlayerDead(player)){
            System.out.println(player.getName() + "has died!");
        } else if(isEnemyDefeated(enemy)){
            System.out.println(enemy.getEnemyName() + "has been defeated!");
        }

        input.close();
    }

    public boolean lootSpaceArea(Scanner scanner);

    default void displayStory(String filename, Scanner userInput) {
        StringBuilder block = new StringBuilder();
        //InputStream is = getClass().getResourceAsStream("/" + filename);

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    // Print the collected block, then pause
                    if (!block.isEmpty()) {
                        System.out.println(TextColors.PURPLE + block.toString().trim() + TextColors.RESET);
                        System.out.println(TextColors.YELLOW + "\nPress Enter to continue..." + TextColors.RESET);
                        userInput.nextLine();
                        block.setLength(0); // clear for next block
                    }
                } else {
                    block.append(line).append("\n");
                }
            }

            // Print any remaining text after the last blank line
            if (!block.isEmpty()) {
                System.out.println(TextColors.PURPLE + block.toString().trim() + TextColors.RESET);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    default boolean isPlayerDead(Player player){
        return player.getPlayerStats().getHpLevel() <= 0;
    }

    default boolean isEnemyDefeated(Enemy enemy){
        return enemy.getEnemStats().getHpLevel() <= 0;
    }
    // END OF COMBAT

    // INVENTORY

}
