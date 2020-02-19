package niewidzialny84.github.headless;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import niewidzialny84.github.headless.mob.Mob;
import niewidzialny84.github.headless.mob.special.*;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.UUID;

public class DeathListener implements Listener {
    private Plugin plugin;
    public DeathListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerDeath(PlayerDeathEvent e) {
        if(e.getEntity().getPlayer() != null) {
            if(Config.configMap.get("PLAYER").getKey()) {
                Random randomGenerator = new Random();
                double random = randomGenerator.nextDouble();
                double chance = Config.configMap.get("PLAYER").getValue();

                if(random <= chance) {
                    ItemStack head = new ItemStack(Material.PLAYER_HEAD,1);
                    ItemMeta meta = head.getItemMeta();
                    ((SkullMeta)meta).setOwningPlayer(e.getEntity());
                    head.setItemMeta(meta);
                    e.getEntity().getLocation().getWorld().dropItem(e.getEntity().getLocation(),head);
                }
            }
        }
    }

    @EventHandler
    public void mobDeath(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Entity entity = e.getEntity();
            switch (entity.getType()) {
                case CREEPER:
                    if (Config.configMap.get("CREEPER").getKey()) {
                        dropItem(e.getEntity().getLocation(), Config.configMap.get("CREEPER").getValue(), new ItemStack(Material.CREEPER_HEAD, 1), "CREEPER");
                    }
                    break;
                case ZOMBIE:
                    if (Config.configMap.get("ZOMBIE").getKey()) {
                        dropItem(e.getEntity().getLocation(), Config.configMap.get("ZOMBIE").getValue(), new ItemStack(Material.ZOMBIE_HEAD, 1), "ZOMBIE");
                    }
                    break;
                case SKELETON:
                    if (Config.configMap.get("SKELETON").getKey()) {
                        dropItem(e.getEntity().getLocation(), Config.configMap.get("SKELETON").getValue(), new ItemStack(Material.SKELETON_SKULL, 1), "SKELETON");
                    }
                    break;
                case CAT:
                    if (Config.configMap.get("CAT").getKey()) {
                        dropItem(e.getEntity().getLocation(), Cats.getCat(entity).mobhead, Config.configMap.get("CAT").getValue());
                    }
                    break;
                case HORSE:
                    if (Config.configMap.get("HORSE").getKey()) {
                        dropItem(e.getEntity().getLocation(), Horses.getHorse(entity).mobHead, Config.configMap.get("HORSE").getValue());
                    }
                    break;
                case LLAMA:
                    if (Config.configMap.get("LLAMA").getKey()) {
                        dropItem(e.getEntity().getLocation(), Llamas.getLlama(entity).mobHead, Config.configMap.get("LLAMA").getValue());
                    }
                    break;
                case PANDA:
                    if (Config.configMap.get("PANDA").getKey()) {
                        dropItem(e.getEntity().getLocation(), Pandas.getPanda(entity).mobHead, Config.configMap.get("PANDA").getValue());
                    }
                    break;
                case PARROT:
                    if (Config.configMap.get("PARROT").getKey()) {
                        dropItem(e.getEntity().getLocation(), Parrots.getParrot(entity).mobHead, Config.configMap.get("PARROT").getValue());
                    }
                    break;
                case RABBIT:
                    if (Config.configMap.get("RABBIT").getKey()) {
                        dropItem(e.getEntity().getLocation(), Rabbits.getRabbit(entity).mobHead, Config.configMap.get("RABBIT").getValue());
                    }
                    break;
                case SHEEP:
                    if (Config.configMap.get("SHEEP").getKey()) {
                        dropItem(e.getEntity().getLocation(), Sheeps.getSheep(entity).mobHead, Config.configMap.get("SHEEP").getValue());
                    }
                    break;
                default:
                    for (Mob x : Mob.values()) {
                        if (entity.getType().equals(x.entity)) {
                            if (Config.configMap.get(x.name()).getKey()) {
                                dropItem(e.getEntity().getLocation(), x.mobHead, Config.configMap.get(x.name()).getValue());
                            }
                            break;
                        }
                    }
                    break;
            }
        }
    }

    private void dropItem(Location location, MobHead type,double chance) {
        Random randomGenerator = new Random();
        double random = randomGenerator.nextDouble();

        if(random <= chance) {
            location.getWorld().dropItem(location,getTexturedSkull(type.getName(),type.getUrl()));
        }
    }

    private void dropItem(Location location,double chance,ItemStack drop,String type) {
        Random randomGenerator = new Random();
        double random = randomGenerator.nextDouble();

        if(random <= chance) {
            location.getWorld().dropItem(location,drop);
        }
    }
/*
    private double permChance(String type, double chance) {
        for(PermissionAttachmentInfo x : p.getEffectivePermissions()) {
            String permission = x.getPermission();
            if(StringUtil.startsWithIgnoreCase(permission,"headless."+type)) {
                String value = permission.split(Pattern.quote("."))[2];
                chance = Double.valueOf(value)/100;
                break;
            }
        }
        return chance;
    }
*/
    public static ItemStack getTexturedSkull(String name, String encodedURL) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.fromString("e6583bd1-fc98-4fe9-a337-fe54c5de827b"), name);
        profile.getProperties().put("textures", new Property("textures", new String(encodedURL)));
        Field profileField = null;
        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        profileField.setAccessible(true);
        try {
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        head.setItemMeta(headMeta);
        return head;
    }

    public static ItemStack getPlayerHead (OfflinePlayer player) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD,1);
        ItemMeta meta = head.getItemMeta();
        ((SkullMeta)meta).setOwningPlayer(player);
        head.setItemMeta(meta);
        return head;
    }

}
