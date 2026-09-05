package textrpg.game;
/**
 * 
 * Thief
 */
public class Thief extends Enemy {
    private final int attackInterval = 8; // knife interval
    private long lastAttack =0;

    public Thief(String name){
        super(name, new Stats(12, new Weapon("Wood Knife", 10,2,2)));
    }

    @Override 
    public void attack(Player player){
        int playerHp = player.getPlayerStats().getHpLevel();
        if(this.getEnemStats().getHpLevel() <= 0 || playerHp <= 0) return;

        long elapsed = (System.currentTimeMillis() - lastAttack) / 1000;
        boolean canAttack = elapsed >= attackInterval;

        if(lastAttack == 0 || canAttack){ // first time and every 8 seconds
            int damage = handleWeaponAttack(this.getEnemStats().getWeapon());
            if(damage > 0){
                player.getPlayerStats().setHpLevel(playerHp - damage);
                lastAttack = System.currentTimeMillis();
            }
        }
    }

}
