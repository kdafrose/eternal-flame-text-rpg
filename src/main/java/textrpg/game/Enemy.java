package textrpg.game;
/**
 * 
 * Enemy Class
 * Subclasses: Thief, Witch, TreeTroll, and HollowKnight
 */
public class Enemy {
    private String name;
    private Stats enemyStats;

    public Enemy(String name, Stats stats){
        this.name = name;
        this.enemyStats = stats;
    }

    //setters
    public void setEnemyName(String name){this.name = name;}
    public void setEnemyStats(Stats stats){this.enemyStats = stats;}
    //gettters
    public String getEnemyName(){return this.name;}
    public Stats getEnemStats(){return this.enemyStats;}

    protected int handleWeaponAttack(Usable weapon){
        if(!weapon.canUse()){
            System.err.println(this.getEnemyName() + "'s weapon is broken!");
            return 1;
        }
        weapon.markUsed();
        return weapon.getStrength();

    }

    protected void handlePowerAttack(Usable power, Player player){
        int playerHp = player.getPlayerStats().getHpLevel();
        if(this.getEnemStats().getHpLevel() <= 0 || playerHp <=0) return;

        if(!power.canUse()){
            System.err.println(this.name + "'s " + power.getName() + " is cooling down! Now is your chance to attack!");
            return;
        }
        power.markUsed();
        int damage = power.getStrength();
        player.getPlayerStats().setHpLevel(playerHp - damage);
    }
}
