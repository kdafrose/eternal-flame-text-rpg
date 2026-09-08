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

        System.out.println("Ophelia has given you a Health Potion.");
        player.getPlayersInventory().addItem(new Items("Health Potion", 10, 10));

        displayStory(part2, input);
        System.out.println(TextColors.RED + "COMBAT STARTED: " + this.player.getName() + " vs " + this.enemy.getEnemyName()) ;
        return playCombat(player, enemy, input);
    }

    @Override
    public boolean lootSpaceArea(Scanner input) {
        System.out.println(TextColors.YELLOW + "What do you want to do?" + TextColors.RESET);

        String userResponse = input.nextLine().toUpperCase(); // .toUpperCase() so "north" works too

        return switch (userResponse) {
            case "SOUTH" -> {
                System.out.println(player.getName() + " has ended up back at the gates.");
                yield false;
            }
            case "EAST" -> {
                playerPickupWeapon(this.lootWeapon, player);
                System.out.println(this.player.getName() + " picked up a " + this.lootWeapon.getName() + "!");
                yield false;
            }
            case "WEST" -> {
                playerPickupGold(player, lootGold);
                System.out.println(this.player.getName() + " picked up " + this.lootGold + "g!");
                yield false;
            }
            case "NORTH" -> {
                System.out.println(TextColors.YELLOW + "Exiting Kingdom..." + TextColors.RESET);
                yield true;
            }
            default -> {
                System.out.println("Invalid direction.");
                yield false;
            }
        };
    }
}
