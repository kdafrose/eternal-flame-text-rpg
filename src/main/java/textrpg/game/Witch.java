package textrpg.game;
/**
 * 
 * Witch
 */
public class Witch extends Enemy{
    public Witch(String name){
        super(name, new Stats(20, new Power("Shatter Hex", 5, 6)));
    }

    @Override 
    public void attack(Player player){
        handlePowerAttack(this.getEnemStats().getPower(), player);
    }
}
