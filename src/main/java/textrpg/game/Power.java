package textrpg.game;

public class Power implements Usable{
    private String name;
    private int strength;
    private double useInterval;
    private long timeStampUsed = 0;

    public Power(String name, int strength, double useInterval){
        this.name = name;
        this.strength = strength;
        this.useInterval = useInterval;
    }

    //setters
    public void setPowerName(String name){this.name = name;}
    public void setPowerStrength(int strength){this.strength = strength;}
    public void setPowerUseInterval(int useInterval){this.useInterval = useInterval;}
    //getters
    public String getPowerName(){return this.name;}
    public int getPowerStrength(){return this.strength;}
    public double getPowerUseInterval(){return this.useInterval;}

    @Override
    public boolean canUse(){
        if(this.timeStampUsed == 0) return true;
        long timeElapsed = (System.currentTimeMillis() - this.timeStampUsed) / 1000;
        return timeElapsed >= useInterval; // if greater or equal to useInterval
    }

    @Override
    public double getCooldownRemaining(){
        long elapsed = (System.currentTimeMillis() - this.timeStampUsed) / 1000;
        return Math.max(0,(useInterval - elapsed));
    }

    @Override
    public void markUsed(){
        this.timeStampUsed = System.currentTimeMillis();
    }

    @Override
    public int getStrength(){return this.strength;}

    @Override
    public String getName(){return this.name;}
}
