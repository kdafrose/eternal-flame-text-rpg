package textrpg.game.attacks;

import textrpg.game.AttackStrategy;
import textrpg.game.Stats;
import textrpg.game.enums.TextColors;

public class KickAttack implements AttackStrategy{
    @Override 
    public int execute(Stats playerStats){
        System.out.println(TextColors.GREEN + "Enemy has been kicked!\n");
        return 1;
    }
}
