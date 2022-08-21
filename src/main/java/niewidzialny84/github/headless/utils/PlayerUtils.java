package niewidzialny84.github.headless.utils;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class PlayerUtils
{
    public static int getPlayerLootingInMainHand(Player player)
    {
        int looting = 0;

        return player.getInventory()
                .getItemInMainHand()
                .getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
    }
}
