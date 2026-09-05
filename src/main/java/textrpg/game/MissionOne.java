package textrpg.game;
import java.util.Scanner;

import textrpg.game.enums.TextColors;
/**
 * MissionOne:
 * The Player has accepted the mission to save the kingdom and is now getting ready for the adventure ahead..
 * Player with fairy will head to the main gates but encounters its first enemy a thief!
 */

public class MissionOne implements Gameplay{
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

    public void PlayMissionOne(Scanner input){
        String part1 = "eternal-flame/src/main/resources/mission_01_part1.txt";
        displayStory(part1, input);

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
                playerPickupWeapon(this.lootWeapon);
                System.out.println(this.player.getName() + " picked up a " + this.lootWeapon.getName() + "!");
                yield false;
            }
            case "WEST" -> {
                playerPickupGold();
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

    private void playerPickupWeapon(Weapon weapon){
        player.getPlayerStats().setWeapon(weapon);
    }

    private void playerPickupGold(){
        int currentGold = player.getMoney();
        player.setMoney(lootGold + currentGold);
    }
}
