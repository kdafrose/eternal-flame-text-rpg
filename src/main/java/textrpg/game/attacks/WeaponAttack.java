package textrpg.game.attacks;

import textrpg.game.AttackStrategy;
import textrpg.game.Stats;
import textrpg.game.Weapon;
import textrpg.game.enums.TextColors;

public class WeaponAttack implements AttackStrategy{
    @Override
    public int execute(Stats playerStats) {
        Weapon weapon = playerStats.getWeapon();
        if (weapon == null) {
            System.out.println(TextColors.RED + "You don't have a weapon.\n");
            return 0;
        }
        if (!weapon.canUse()) {
            System.out.println(TextColors.RED + weapon.getName() + " is broken!\n");
            return 0;
        }
        weapon.markUsed();
        return weapon.getStrength();
    }
}
