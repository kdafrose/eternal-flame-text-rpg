package textrpg.game;

public class DarkSourcerer extends Enemy implements Combat{
    public DarkSourcerer(String name){
        super(name, new Stats(55, new Power("Dusk Wave", 8, 2)));
    }

    @Override
    public void attack(Player player){
        handlePowerAttack(this.getEnemStats().getPower(), player);
    }
}
