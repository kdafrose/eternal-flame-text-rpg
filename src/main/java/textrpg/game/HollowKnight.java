package textrpg.game;
/**
 * 
 * HollowKnight
 */
public class HollowKnight extends Enemy{
    public HollowKnight(String name){
        super(name, new Stats(45, new Power("Void Surge", 6, 2.5)));
    }

    @Override
    public void attack(Player player){
        handlePowerAttack(this.getEnemStats().getPower(), player);
    }
}
