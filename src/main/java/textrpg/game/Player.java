package textrpg.game;

import textrpg.game.enums.TextColors;

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
                System.out.println(TextColors.GREEN + "Enemy been punched!\n");
                yield 1;
            }
            case "kick" -> {
                System.err.println(TextColors.GREEN + "Enemy has been kicked!\n");
                yield 1;
            }
            case "power" -> {
                if(this.playerStats.getPower() == null){
                    System.out.println(TextColors.RED + this.name + "does not have any powers.\n");
                    yield 0;
                }
                yield handleUse(equippedPower);
            }

            case "weapon" -> {
                if(this.playerStats.getWeapon() == null){
                    System.out.println(TextColors.RED + this.name + "does not have a weapon.\n");
                    yield 0;
                }
                yield equippedWeapon.getStrength();
            }
            default -> {
                System.err.println(TextColors.RED + "Invalid Attack\n");
                yield 0;
            }
        };
    }

    private int handleUse(Usable item){
        if(!item.canUse()){
            System.err.println(TextColors.GREEN + item.getName() + "is cooling! Available in " + item.getCooldownRemaining());
            return 0;
        }
        item.markUsed();
        return item.getStrength();
    }
}
