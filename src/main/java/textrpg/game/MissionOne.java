package textrpg.game;
import java.util.Scanner;

import textrpg.game.enums.TextColors;
/**
 * MissionOne:
 * The Player has accepted the mission to save the kingdom and is now getting ready for the adventure ahead..
 * Player with fairy will head to the main gates but encounters its first enemy a thief!
 */

public class MissionOne implements Mission, Gameplay{
    private final Enemy enemy;
    private final Weapon lootWeapon;
    private final int lootGold;
    private final Player player;

    public MissionOne(Player player){
        this.enemy = new Thief("Creepy Old Man");
        this.lootWeapon = new Weapon("Small Knife", 12, 2, 2);
        this.lootGold = 20;
        this.player = player;
    }

    @Override
    public boolean playMission(Scanner input){
        String part1 = "eternal-flame/src/main/resources/mission_01_part1.txt";
        String part2 = "eternal-flame/src/main/resources/mission_01_part2.txt";
        displayStory(part1, input);

        System.out.println(TextColors.GREEN + "\nOphelia has given you a Health Potion." + TextColors.RESET);
        player.getPlayersInventory().addItem(new Items("Health Potion", 10, 10));

        displayStory(part2, input);
        System.out.println(TextColors.RED + "COMBAT STARTED: " + this.player.getName() + " vs " + this.enemy.getEnemyName()) ;
        return playCombat(player, enemy, input);
    }

    @Override
    public boolean lootSpaceArea(Scanner input) {
        displayDirections();
        System.out.println("go NORTH to exit");
        System.out.println(TextColors.YELLOW + "What do you want to do?\n" + TextColors.RESET);

        String userResponse = input.nextLine().toUpperCase(); // .toUpperCase() so "north" works too
        return switch (userResponse) {
            case "SOUTH" -> {
                System.out.println(player.getName() + " has ended up back at the gates.");
                yield true;
            }
            case "EAST" -> {
                playerPickupWeapon(this.lootWeapon, player);
                System.out.println(TextColors.GREEN + this.player.getName() + " picked up a " + this.lootWeapon.getName() + "!");
                yield true;
            }
            case "WEST" -> {
                playerPickupGold(player, lootGold);
                System.out.println( TextColors.GREEN + this.player.getName() + " picked up " + this.lootGold + "g!");
                yield true;
            }
            case "NORTH" -> {
                System.out.println(TextColors.YELLOW + "Exiting   ..." + TextColors.RESET);
                yield false;
            }
            default -> {
                System.out.println("Invalid direction.");
                yield true;
            }
        };
    }
}
