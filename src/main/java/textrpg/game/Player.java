package textrpg.game;

public class Player{
    private String name;
    private int money;
    private Stats playerStats;
    private Inventory playerInventory;

    public Player(String name){
        this.name = name;
        this.money = 0;
        this.playerStats = new Stats(15);
        this.playerInventory = new Inventory();
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
        Weapon equippedWeapon = this.playerStats.getWeapon();
        Power equippedPower = this.playerStats.getPower();

        return switch(lowerCase){
            case "punch" -> {
                System.out.println("Enemy been punched!");
                yield 1;
            }
            case "kick" -> {
                System.err.println("Enemy has been kicked!");
                yield 1;
            }
            case "power" -> handleUse(equippedPower);

            case "weapon" -> equippedWeapon.getStrength();
            default -> {
                System.err.println("Invalid Attack");
                yield 0;
            }
        };
    }

    private int handleUse(Usable item){
        if(!item.canUse()){
            System.err.println(item.getName() + "is cooling! Available in " + item.getCooldownRemaining());
            return 0;
        }
        item.markUsed();
        return item.getStrength();
    }
}
