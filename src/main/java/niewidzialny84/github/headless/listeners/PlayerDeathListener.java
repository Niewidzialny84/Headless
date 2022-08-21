package niewidzialny84.github.headless.listeners;

import niewidzialny84.github.headless.configuration.Configuration;
import niewidzialny84.github.headless.Headless;
import niewidzialny84.github.headless.utils.PlayerUtils;
import niewidzialny84.github.headless.utils.RandomGenerator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PlayerDeathListener implements Listener
{
    private final Headless plugin;

    private final Configuration config;

    private final static String PLAYER = "PLAYER";

    public PlayerDeathListener(Headless plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);

        config = plugin.getConfiguration();
    }

    @EventHandler
    public void playerDeath(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();

        if(player != null) {
            if(config.configMap.get(PLAYER).isDrop()) {
                double random = RandomGenerator.randomDouble();
                double chance = config.configMap.get(PLAYER).getChance();
                double looting = 0;

                if (player.getKiller() != null)
                {
                    looting = config.configMap.get(PLAYER).getLooting();
                    looting = (looting * PlayerUtils.getPlayerLootingInMainHand(player.getKiller()));
                }

                chance += looting;

                if(random <= chance) {
                    ItemStack head = new ItemStack(Material.PLAYER_HEAD,1);
                    ItemMeta meta = head.getItemMeta();
                    if (meta != null) {
                        ((SkullMeta)meta).setOwningPlayer(e.getEntity());
                        head.setItemMeta(meta);
                        e.getEntity().getLocation().getWorld().dropItem(e.getEntity().getLocation(),head);
                    }
                }
            }
        }
    }
}
