package textrpg.game.attacks;

import textrpg.game.AttackStrategy;
import textrpg.game.Stats;
import textrpg.game.enums.TextColors;

public class PunchAttack implements AttackStrategy{
    @Override 
    public int execute(Stats playerStats){
        System.out.println(TextColors.GREEN + "Enemy been punched!\n");
        return 1;
    }
}
