package textrpg.game;

public class Items {
    private String name;
    private int price;
    private int useAmount;

    public Items(String name, int price, int useAmount){
        this.name = name;
        this.price = price;
        this.useAmount = useAmount;
    }

    //setters
    public void setName(String name){this.name = name;}
    public void setPrice(int price){this.price = price;}
    public void setUseAmount(int useAmount){this.useAmount = useAmount;}
    //getters
    public String getName(){return this.name;}
    public int getPrice(){return this.price;}
    public int getUseAmount(){return this.useAmount;}
}
