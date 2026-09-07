package textrpg.game;
import java.util.Scanner;

import textrpg.game.enums.TextColors;

public class Game {
    private final Scanner scanner;
    private Player player;
    private final Items[] store = {
        new Items("Health Potion", 10, 10),
        new Items("Heal Weapon", 20, 15),
        new Items("Upgrade Weapon",15, 6),
        new Items("Upgrade Power Strength", 20, 8),
        new Items("Upgrade Power Use", 25, 3)
    };

    public Game(Scanner scanner){
        this.player = null;
        this.scanner = scanner;
    }

    public void initializeGame(){
        System.out.println( TextColors.PURPLE +
            "\t\t\t#####################################################\n" +
            "\t\t\t#                                                   #\n" +
            "\t\t\t#           Welcome to Eternal Flame!               #\n" +
            "\t\t\t#                                                   #\n" +
            "\t\t\t#              A Text Based Adventure               #\n" +
            "\t\t\t#                                                   #\n" +
            "\t\t\t#####################################################"
            + TextColors.RESET
        );

        System.out.print(TextColors.YELLOW + "Enter your Players name: " + TextColors.RESET);
        String playerName = scanner.nextLine();
        this.player = new Player(playerName);
    }

    public void endGame(){
        scanner.close();
    }

    public void runMissions(){
        MissionOne missionOne = new MissionOne(this.player);
        missionOne.PlayMissionOne(this.scanner);
    }

     // POTIONS STORE
    public void displayPotionsStore(){
        System.out.println(TextColors.BLUE +
        "\n\t\t\t#####################################################\n" +
        "\t\t\t#                   OLD MIRA'S STALL                #\n" +
        "\t\t\t#####################################################\n" +
        "\t\t\t#                                                   #\n" +
        "\t\t\t#   [1]  Health Potion                       - 10g  #\n" +
        "\t\t\t#   [2]  Heal Weapon                         - 20g  #\n" +
        "\t\t\t#   [3]  Upgrade Weapon                      - 15g  #\n" +
        "\t\t\t#   [4]  Upgrade Power Strength              - 20g  #\n" +
        "\t\t\t#   [5]  Upgrade Power Use                   - 25g  #\n" +
        "\t\t\t#                                                   #\n" +
        "\t\t\t#   [0]  Leave Stall                                #\n" +
        "\t\t\t#                                                   #\n" +
        "\t\t\t#####################################################" +
        TextColors.RESET);
    
    }

    public void runPotionsStore() {
        boolean shopping = true;

        while (shopping) {
            displayPotionsStore();
            System.out.println(TextColors.YELLOW + "Your Gold: " + player.getMoney() + "g" + TextColors.RESET);
            System.out.print(TextColors.YELLOW + "\nWhat would you like to buy? " + TextColors.RESET);

            String userChoice = scanner.nextLine().trim();

            // handle exit first
            if (userChoice.equals("0")) {
                System.out.println(TextColors.PURPLE + "\nOPHELIA: \"Safe travels, brave one!\"" + TextColors.RESET);
                shopping = false;
                continue;
            }

            // validate input is a number
            int choice;
            try {
                choice = Integer.parseInt(userChoice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            // validate range
            if (choice < 1 || choice > store.length) {
                System.out.println("Please pick a number between 1 and " + store.length + ".");
                continue;
            }

            // check gold
            Items selected = store[choice - 1];
            if (player.getMoney() < selected.getPrice()) {
                System.out.println(TextColors.PURPLE + "You don't have enough gold to buy " + selected.getName() + "!" + TextColors.RESET);
                continue;
            }

            // purchase
            player.setMoney(player.getMoney() - selected.getPrice());
            player.getPlayersInventory().addItem(selected);
            System.out.println("You purchased a " + selected.getName() + "! Remaining gold: " + player.getMoney() + "g");
        }
    }

    
}
