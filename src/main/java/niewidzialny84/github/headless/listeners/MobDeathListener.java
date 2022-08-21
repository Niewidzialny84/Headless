package niewidzialny84.github.headless.listeners;

import niewidzialny84.github.headless.configuration.Configuration;
import niewidzialny84.github.headless.Headless;
import niewidzialny84.github.headless.mob.Mob;
import niewidzialny84.github.headless.mob.special.*;
import niewidzialny84.github.headless.utils.ItemDrop;
import niewidzialny84.github.headless.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobDeathListener implements Listener
{
    private final Headless plugin;

    private final Configuration config;

    public MobDeathListener(Headless plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);

        config = plugin.getConfiguration();
    }


    @EventHandler
    public void mobDeath(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Entity entity = e.getEntity();
            Player killer = e.getEntity().getKiller();

            switch (entity.getType()) {
                case CREEPER:
                    if (config.configMap.get("CREEPER").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), getLootingChance("CREEPER", killer), new ItemStack(Material.CREEPER_HEAD, 1));
                    }
                    break;
                case ZOMBIE:
                    if (config.configMap.get("ZOMBIE").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), getLootingChance("ZOMBIE", killer), new ItemStack(Material.ZOMBIE_HEAD, 1));
                    }
                    break;
                case SKELETON:
                    if (config.configMap.get("SKELETON").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), getLootingChance("SKELETON", killer), new ItemStack(Material.SKELETON_SKULL, 1));
                    }
                    break;
                case WITHER_SKELETON:
                    if (config.configMap.get("WITHER_SKELETON").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), getLootingChance("WITHER_SKELETON", killer), new ItemStack(Material.WITHER_SKELETON_SKULL, 1));
                    }
                    break;
                case CAT:
                    if (config.configMap.get("CAT").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), Cats.getCat(entity).mobhead, getLootingChance("CAT", killer));
                    }
                    break;
                case HORSE:
                    if (config.configMap.get("HORSE").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), Horses.getHorse(entity).mobHead, getLootingChance("HORSE", killer));
                    }
                    break;
                case LLAMA:
                    if (config.configMap.get("LLAMA").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), Llamas.getLlama(entity).mobHead, getLootingChance("LLAMA", killer));
                    }
                    break;
                case PANDA:
                    if (config.configMap.get("PANDA").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), Pandas.getPanda(entity).mobHead, getLootingChance("PANDA", killer));
                    }
                    break;
                case PARROT:
                    if (config.configMap.get("PARROT").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), Parrots.getParrot(entity).mobHead, getLootingChance("PARROT", killer));
                    }
                    break;
                case RABBIT:
                    if (config.configMap.get("RABBIT").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), Rabbits.getRabbit(entity).mobHead, getLootingChance("RABBIT", killer));
                    }
                    break;
                case SHEEP:
                    if (config.configMap.get("SHEEP").isDrop()) {
                        new ItemDrop(e.getEntity().getLocation(), Sheep.getSheep(entity).mobHead, getLootingChance("SHEEP", killer));
                    }
                    break;
                default:
                    for (Mob x : Mob.values()) {
                        if (entity.getType().equals(x.entity)) {
                            if (config.configMap.get(x.name()).isDrop()) {
                                new ItemDrop(e.getEntity().getLocation(), x.mobHead, getLootingChance(x.name(), killer));
                            }
                            break;
                        }
                    }
                    break;
            }
        }
    }

    private double getLootingChance(String name, Player killer)
    {
        double chance = config.configMap.get(name).getChance();
        double looting = config.configMap.get(name).getLooting();
        return chance + (looting * PlayerUtils.getPlayerLootingInMainHand(killer));
    }
}
