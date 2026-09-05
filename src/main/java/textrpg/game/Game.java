package textrpg.game;
import java.util.Scanner;

import textrpg.game.enums.TextColors;

public class Game {
    private Scanner scanner;
    private Player player;

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

    
}
