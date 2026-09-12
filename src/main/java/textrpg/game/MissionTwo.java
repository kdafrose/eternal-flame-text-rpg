package textrpg.game;
import java.util.Scanner;

public class MissionTwo implements Mission,Gameplay{
    private final Enemy enemy;
    private final int lootGold;
    private final Player player;
    private final Power lootPower;

    public MissionTwo(Player player){
        this.player = player;
        this.enemy = new Witch("Old Hag");
        this.lootGold = 20;
        this.lootPower = new Power("Shard something", 8, 3);
    }

    @Override 
    public boolean playMission(Scanner scanner){
        System.out.println("Has reached mission 2 congrats ig");
        return false;
    }

    @Override
    public boolean lootSpaceArea(Scanner input){
        return true;
    }
}
