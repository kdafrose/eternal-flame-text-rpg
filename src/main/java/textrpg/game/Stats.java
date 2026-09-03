package textrpg.game;

public class Stats {
    private int hpLevel;
    private Weapon weapon;
    private Power power;

    public Stats(int hpLevel){
        this.hpLevel = hpLevel;
        this.weapon = null;
        this.power = null;
    }

    public Stats(int hpLevel, Weapon weapon){
        this.hpLevel = hpLevel;
        this.weapon = weapon;
        this.power = null;
    }

        public Stats(int hpLevel, Power power){
        this.hpLevel = hpLevel;
        this.weapon = null;
        this.power = power;
    }

    public Stats(int hpLevel, Weapon weapon, Power power){
        this.hpLevel = hpLevel;
        this.weapon = weapon;
        this.power = power;
    }

    //setters 
    public void setHpLevel(int hpLevel){this.hpLevel = hpLevel;}
    public void setWeapon(Weapon weapon){this.weapon = weapon;}
    public void setPower(Power power){this.power = power;}
    //getters
    public int getHpLevel(){return this.hpLevel;}
    public Weapon getWeapon(){return this.weapon;}
    public Power getPower(){return this.power;}
}
