package textrpg.game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import textrpg.game.enums.TextColors;

public interface Gameplay {
    // COMBAT
    public default boolean playCombat(Player player, Enemy enemy, Scanner input){
        try (Scanner scanner = input) {
            while(!isPlayerDead(player) && !isEnemyDefeated(enemy)){
                System.out.println(TextColors.YELLOW +"Commands: KICK, PUNCH, POWER, WEAPON");
                String attackString = scanner.nextLine().toUpperCase();
                player.attack(attackString);

                if(!isEnemyDefeated(enemy)){
                    enemy.attack(player);
                }
            }

            if(isPlayerDead(player)){
                System.out.println(TextColors.RED + player.getName() + "has died!");
                return false;
            } 
            
            System.out.println(TextColors.BLUE + enemy.getEnemyName() + "has been defeated!");
            return true;
        }
    }

    // Loot Logic
    public boolean lootSpaceArea(Scanner scanner);

    default void playerPickupWeapon(Weapon weapon, Player player){
        player.getPlayerStats().setWeapon(weapon);
    }
    default void playerPickupGold(Player player, int lootGold){
        int currentGold = player.getMoney();
        player.setMoney(lootGold + currentGold);
    }

    // Helper functions
    default void displayStory(String filename, Scanner userInput) {
        StringBuilder block = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    // Print the collected block, then pause
                    if (!block.isEmpty()) {
                        System.out.println(TextColors.PURPLE + block.toString().trim() + TextColors.RESET);
                        System.out.print(TextColors.YELLOW + "\nPress Enter to continue..." + TextColors.RESET);
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
}
