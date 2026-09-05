package textrpg.game;
/**
 * 
 * TreeTroll
 */
public class TreeTroll extends Enemy{
    public TreeTroll(String name){
        super(name, new Stats(35, new Power("Earthpike Surge", 8, 7)));
    }

    @Override
    public void attack(Player player){
        handlePowerAttack(this.getEnemStats().getPower(), player);    
    }
}
