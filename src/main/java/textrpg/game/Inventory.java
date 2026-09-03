package textrpg.game;
//import eternalflame.game.enums.TextColors;

public class Inventory {
    private Items[] items;
    private int size;
    private final int CAPACITY = 10;

    public Inventory(){
        this.items = new Items[CAPACITY];
        this.size = 0;
    }

    public Items[] getInventory(){return this.items;}

    //add item
    public boolean addItem(Items item){
        if(this.size >= CAPACITY){
            System.out.println("Inventory reached maximum capacity");
            return false;
        }
        this.items[size] = item;
        this.size++;
        System.out.println(item.getName() + " has beed added to your inventory");
        return true;
    }

    //remove item
    public boolean removeItem(int index){
        if(index < 0 || index >= this.size) {
            System.out.println("Item cannot be found and removed.");
            return false;
        }

        for(int i = index; i < this.size; i++){
            this.items[i] = items[i+1];
        }
        this.size--;
        return true;
    }

    public void clearInventory(){
        this.items = null;
        this.items = new Items[CAPACITY];
    }
}
