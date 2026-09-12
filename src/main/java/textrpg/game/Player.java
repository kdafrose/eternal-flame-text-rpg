package textrpg.game;

import java.util.HashMap;
import java.util.Map;

import textrpg.game.attacks.KickAttack;
import textrpg.game.attacks.PowerAttack;
import textrpg.game.attacks.PunchAttack;
import textrpg.game.attacks.WeaponAttack;
import textrpg.game.enums.TextColors;

public class Player{
    private String name;
    private int money;
    private Stats playerStats;
    private Inventory playerInventory;
    private final Map<String, AttackStrategy> attackStrategies;

    public Player(String name){
        this.name = name;
        this.money = 0;
        this.playerStats = new Stats(15);
        this.playerInventory = new Inventory();

        this.attackStrategies = new HashMap<>();
        attackStrategies.put("punch",  new PunchAttack());
        attackStrategies.put("kick",   new KickAttack());
        attackStrategies.put("weapon", new WeaponAttack());
        attackStrategies.put("power",  new PowerAttack());
    }

    //setters
    public void setMoney(int money){this.money=money;}
    public void setName(String name){this.name=name;}
    public void setStats(Stats stats){this.playerStats = stats;}
    public void setInventory(Inventory inventory){this.playerInventory = inventory;}
    //getters
    public String getName(){return this.name;}
    public int getMoney(){return this.money;}
    public Inventory getPlayersInventory(){return this.playerInventory;}
    public Stats getPlayerStats(){return this.playerStats;}


    //Combat
    public int attack(String attackString){
        if(this.playerStats.getHpLevel() <= 0) return 0;

        String lowerCase = attackString.toLowerCase();

        AttackStrategy attack = attackStrategies.get(lowerCase);
        if(attack == null){
            System.out.println(TextColors.RED + "Not a valid attack.");
            return 0;
        }

        return attack.execute(playerStats);
    }
}
