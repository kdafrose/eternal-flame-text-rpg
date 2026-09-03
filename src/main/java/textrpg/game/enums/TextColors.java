package textrpg.game.enums;

public enum TextColors {
    RESET   ("\u001B[0m"),
    RED     ("\u001B[31m"),
    GREEN   ("\u001B[32m"),
    YELLOW  ("\u001B[33m"),
    BLUE    ("\u001B[34m"),
    PURPLE  ("\u001B[35m"),
    CYAN    ("\u001B[36m"),
    WHITE   ("\u001B[37m"),
    BOLD    ("\u001B[1m");

    private final String color;

    TextColors(String color){
        this.color = color;
    }

    public String getColorCode(){
        return color;
    }

    @Override
    public String toString() {
        return color;
    }

}
