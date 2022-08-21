package niewidzialny84.github.headless.utils;

import niewidzialny84.github.headless.head.MobHead;
import niewidzialny84.github.headless.head.SkullGenerator;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public final class ItemDrop
{
    public ItemDrop(Location location, MobHead type, double chance) {
        double random = RandomGenerator.randomDouble();

        if(random <= chance) {
            location.getWorld().dropItem(location, SkullGenerator.getTexturedSkull(type.getName(),type.getUrl()));
        }
    }

    public ItemDrop(Location location, double chance, ItemStack drop) {
        double random = RandomGenerator.randomDouble();

        if(random <= chance) {
            location.getWorld().dropItem(location,drop);
        }
    }
}
