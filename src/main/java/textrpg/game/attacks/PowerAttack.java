package textrpg.game.attacks;

import textrpg.game.AttackStrategy;
import textrpg.game.Power;
import textrpg.game.Stats;
import textrpg.game.enums.TextColors;

public class PowerAttack implements AttackStrategy{
    @Override 
    public int execute(Stats playerStats){
        Power power = playerStats.getPower();
        if(power == null){
            System.out.println(TextColors.RED +"Player does not have any powers.\n");
            return 0;
        }

        if(!power.canUse()){
            System.out.println( TextColors.RED + power.getName() + "Power is cooling down! Available in " + power.getCooldownRemaining());
            return 0;
        }

        power.markUsed();
        return power.getPowerStrength();
    }
}
