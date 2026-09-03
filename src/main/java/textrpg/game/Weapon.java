package textrpg.game;

public class Weapon implements Usable{
    private String name;
    private int durability;
    private int strength;
    private final int usability;

    public Weapon(String name, int durability, int strength, int usability){
        this.name = name;
        this.durability = durability;
        this.strength = strength;
        this.usability = usability;
    }

    //setters
    public void setName(String name){this.name = name;}
    public void setDurability(int durability){this.durability = durability;}
    public void setStrength(int strength){this.strength = strength;}

    //getters
    public int getDurability(){return this.durability;}
    public int getUsability(){return this.usability;}

    @Override
    public String getName(){return this.name;}
    @Override
    public int getStrength(){return this.strength;}

    @Override
    public void markUsed(){
        if(this.durability <= 0){
            return;
        }
        this.durability -= this.usability;
    }

    @Override
    public boolean canUse(){
       return this.durability > 0;
    }

    @Override
    public double getCooldownRemaining(){return 0;}
}
