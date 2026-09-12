package textrpg.game;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //remember the loot logic will tell the user that going NORTH will exit the area
        // so make sure to look around to see if there is anything that can be picked up

        Scanner scanner = new Scanner(System.in);
        Game eternalFlame = new Game(scanner);
        Player player = eternalFlame.initializeGame();

        List<Mission> missions = List.<Mission>of(
            new MissionOne(player),
            new MissionTwo(player)
            // new MissionThree(player),
            // new MissionFour(player),
            // new MissionFive(player)
        );

        int i = 0;
        while (i < missions.size()) {
            boolean playerAlive = missions.get(i).playMission(scanner);
            if (!playerAlive) {
                //boolean retry = eternalFlame.playerDeadHandler(scanner);
               // if (!retry) {
                    //return;          // exits main / the game method entirely
                //}
                // retry = i stays the same → replays current mission
                //} else {
                    //i++;                 // advance only on success
                eternalFlame.gameOverScreen();
                return;
            } else {
                eternalFlame.displayCombatVictory();
                boolean stillLooting = true;
                while(stillLooting){
                    stillLooting = missions.get(i).lootSpaceArea(scanner);
                }
                eternalFlame.displayPlayerInventory();
            }
            i++;
        }

        eternalFlame.endGame();

    }
}