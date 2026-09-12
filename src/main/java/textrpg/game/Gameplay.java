package textrpg.game;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import textrpg.game.enums.TextColors;

public interface Gameplay {
    // COMBAT
    public default boolean playCombat(Player player, Enemy enemy, Scanner input){
    
        while(!isPlayerDead(player) && !isEnemyDefeated(enemy)){
            
            if(!isEnemyDefeated(enemy)){
                enemy.attack(player);
            }
            System.out.println(TextColors.YELLOW +"Commands: KICK, PUNCH, POWER, WEAPON");
            String attackString = input.nextLine().toUpperCase();
            int damage = player.attack(attackString);
            enemy.getEnemStats().setHpLevel(enemy.getEnemStats().getHpLevel() - damage);

            if(!isEnemyDefeated(enemy)){
                enemy.attack(player);
            }

        }

        if(isPlayerDead(player)){
            System.out.println(TextColors.RED + player.getName() + " has died!\n");
            return false;
        } 
        
        System.out.println(TextColors.BLUE + enemy.getEnemyName() + " has been defeated!\n");
        return true;
        
    }

    default void playerPickupWeapon(Weapon weapon, Player player){
        player.getPlayerStats().setWeapon(weapon);
    }
    default void playerPickupGold(Player player, int lootGold){
        int currentGold = player.getMoney();
        player.setMoney(lootGold + currentGold);
    }

    // Helper functions
    default void displayDirections(){
        System.out.println(TextColors.BLUE +
        "\n#####################################################\n" +
        "#                                                   #\n" +
        "#        NORTH                                      #\n" +
        "#        SOUTH                                      #\n" +
        "#        EAST                                       #\n" +
        "#        WEST                                       #\n" +
        "#                                                   #\n" +
        "#####################################################" +
        TextColors.RESET);
    }

    default void displayStory(String filename, Scanner userInput) {
        StringBuilder block = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    // Print the collected block, then pause
                    if (!block.isEmpty()) {
                        System.out.println(TextColors.PURPLE + block.toString().trim() + TextColors.RESET);
                        System.out.print(TextColors.YELLOW + "\nPress [Enter] to continue or type SKIP..." + TextColors.RESET);

                        String i = userInput.nextLine().trim();
                        if(i.equals("skip")) return;
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
