package textrpg.game;

public interface Usable {
    boolean canUse();
    double getCooldownRemaining();
    void markUsed();
    int getStrength();
    String getName();
}