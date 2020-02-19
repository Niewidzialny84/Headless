package headless.headless;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
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
        if(e.getEntity().getKiller() != null ) {
            switch ( e.getEntity().getType()) {
                case BAT:
                    if(Config.configMap.get("BAT").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.BAT , Config.configMap.get("BAT").getValue());
                    }
                    break;
                case BEE:
                    if(Config.configMap.get("BEE").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.BEE , Config.configMap.get("BEE").getValue());

                    }
                    break;
                case BLAZE:
                    if(Config.configMap.get("BLAZE").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.BLAZE , Config.configMap.get("BLAZE").getValue());
                    }
                    break;
                case CAT:
                    if(Config.configMap.get("CAT").getKey()) {
                        catDeath(e.getEntity());
                    }
                    break;
                case CAVE_SPIDER:
                    if(Config.configMap.get("CAVE_SPIDER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.CAVE_SPIDER , Config.configMap.get("CAVE_SPIDER").getValue());
                    }
                    break;
                case CHICKEN:
                    if(Config.configMap.get("CHICKEN").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.CHICKEN , Config.configMap.get("CHICKEN").getValue());
                    }
                    break;
                case COW:
                    if(Config.configMap.get("COW").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.COW , Config.configMap.get("COW").getValue());
                    }
                    break;
                case CREEPER:
                    if(Config.configMap.get("CREEPER").getKey()) {
                        dropItem(e.getEntity().getLocation(), Config.configMap.get("CREEPER").getValue(),new ItemStack(Material.CREEPER_HEAD,1),"CREEPER");
                    }
                    break;
                case DROWNED:
                    if(Config.configMap.get("DROWNED").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.DROWNED , Config.configMap.get("DROWNED").getValue());
                    }
                    break;
                case DOLPHIN:
                    if(Config.configMap.get("DOLPHIN").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.DOLPHIN , Config.configMap.get("DOLPHIN").getValue());
                    }
                    break;
                case ELDER_GUARDIAN:
                    if(Config.configMap.get("ELDER_GUARDIAN").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.ELDER_GUARDIAN , Config.configMap.get("ELDER_GUARDIAN").getValue());
                    }
                    break;
                case ENDERMAN:
                    if(Config.configMap.get("ENDERMAN").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.ENDERMAN , Config.configMap.get("ENDERMAN").getValue());
                    }
                    break;
                case EVOKER:
                    if(Config.configMap.get("EVOKER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.EVOKER , Config.configMap.get("EVOKER").getValue());
                    }
                    break;
                case FOX:
                    if(Config.configMap.get("FOX").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.FOX , Config.configMap.get("FOX").getValue());
                    }
                    break;
                case GHAST:
                    if(Config.configMap.get("GHAST").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.GHAST , Config.configMap.get("GHAST").getValue());
                    }
                    break;
                case GUARDIAN:
                    if(Config.configMap.get("GUARDIAN").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.GUARDIAN , Config.configMap.get("GUARDIAN").getValue());
                    }
                    break;
                case HUSK:
                    if(Config.configMap.get("HUSK").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.HUSK , Config.configMap.get("HUSK").getValue());
                    }
                    break;
                case HORSE:
                    if(Config.configMap.get("HORSE").getKey()) {
                        horseDeath(e.getEntity());
                    }
                    break;
                case IRON_GOLEM:
                    if(Config.configMap.get("IRON_GOLEM").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.IRON_GOLEM , Config.configMap.get("IRON_GOLEM").getValue());
                    }
                    break;
                case LLAMA:
                    if(Config.configMap.get("LLAMA").getKey()) {
                        llamaDeath(e.getEntity());
                    }
                    break;
                case MAGMA_CUBE:
                    if(Config.configMap.get("MAGMA_CUBE").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.MAGMA_CUBE , Config.configMap.get("MAGMA_CUBE").getValue());
                    }
                    break;
                case MUSHROOM_COW:
                    if(Config.configMap.get("MUSHROOM_COW").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.MUSHROOM_COW , Config.configMap.get("MUSHROOM_COW").getValue());
                    }
                    break;
                case OCELOT:
                    if(Config.configMap.get("OCELOT").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.OCELOT , Config.configMap.get("OCELOT").getValue());
                    }
                    break;
                case PANDA:
                    if(Config.configMap.get("PANDA").getKey()) {
                        pandaDeath(e.getEntity());
                    }
                    break;
                case PARROT:
                    if(Config.configMap.get("PARROT").getKey()) {
                        parrotDeath(e.getEntity());
                    }
                    break;
                case PHANTOM:
                    if(Config.configMap.get("PHANTOM").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.PHANTOM , Config.configMap.get("PHANTOM").getValue());
                    }
                    break;
                case PIG:
                    if(Config.configMap.get("PIG").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.PIG , Config.configMap.get("PIG").getValue());
                    }
                    break;
                case PIG_ZOMBIE:
                    if(Config.configMap.get("PIG_ZOMBIE").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.PIG_ZOMBIE , Config.configMap.get("PIG_ZOMBIE").getValue());
                    }
                    break;
                case PILLAGER:
                    if(Config.configMap.get("PILLAGER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.PILLAGER , Config.configMap.get("PILLAGER").getValue());
                    }
                    break;
                case POLAR_BEAR:
                    if(Config.configMap.get("POLAR_BEAR").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.POLAR_BEAR , Config.configMap.get("POLAR_BEAR").getValue());
                    }
                    break;
                case RABBIT:
                    if(Config.configMap.get("RABBIT").getKey()) {
                        rabbitDeath(e.getEntity());
                    }
                    break;
                case RAVAGER:
                    if(Config.configMap.get("RAVAGER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.RAVAGER , Config.configMap.get("RAVAGER").getValue());
                    }
                    break;
                case SHEEP:
                    if(Config.configMap.get("SHEEP").getKey()) {
                        sheepDeath(e.getEntity());
                    }
                    break;
                case SHULKER:
                    if(Config.configMap.get("SHULKER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.SHULKER , Config.configMap.get("SHULKER").getValue());
                    }
                    break;
                case SKELETON:
                    if(Config.configMap.get("SKELETON").getKey()) {
                        dropItem(e.getEntity().getLocation(),Config.configMap.get("SKELETON").getValue(),new ItemStack(Material.SKELETON_SKULL,1),"SKELETON");
                    }
                    break;
                case SLIME:
                    if(Config.configMap.get("SLIME").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.SLIME , Config.configMap.get("SLIME").getValue());
                    }
                    break;
                case SQUID:
                    if(Config.configMap.get("SQUID").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.SQUID , Config.configMap.get("SQUID").getValue());
                    }
                    break;
                case SPIDER:
                    if(Config.configMap.get("SPIDER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.SPIDER , Config.configMap.get("SPIDER").getValue());
                    }
                    break;
                case SNOWMAN:
                    if(Config.configMap.get("SNOWMAN").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.SNOWMAN , Config.configMap.get("SNOWMAN").getValue());
                    }
                    break;
                case TURTLE:
                    if(Config.configMap.get("TURTLE").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.TURTLE , Config.configMap.get("TURTLE").getValue());
                    }
                    break;
                case VINDICATOR:
                    if(Config.configMap.get("VINDICATOR").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.VINDICATOR , Config.configMap.get("VINDICATOR").getValue());
                    }
                    break;
                case VEX:
                    if(Config.configMap.get("VEX").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.VEX , Config.configMap.get("VEX").getValue());
                    }
                    break;
                case WITCH:
                    if(Config.configMap.get("WITCH").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.WITCH , Config.configMap.get("WITCH").getValue());
                    }
                    break;
                case WITHER:
                    if(Config.configMap.get("WITHER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.WITHER , Config.configMap.get("WITHER").getValue());
                    }
                    break;
                case WOLF:
                    if(Config.configMap.get("WOLF").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.WOLF , Config.configMap.get("WOLF").getValue());
                    }
                    break;
                case ZOMBIE:
                    if(Config.configMap.get("ZOMBIE").getKey()) {
                        dropItem(e.getEntity().getLocation(),Config.configMap.get("ZOMBIE").getValue(),new ItemStack(Material.ZOMBIE_HEAD,1),"ZOMBIE");
                    }
                    break;
                case ZOMBIE_VILLAGER:
                    if(Config.configMap.get("ZOMBIE_VILLAGER").getKey()) {
                        dropItem(e.getEntity().getLocation(), MobHead.ZOMBIE_VILLAGER , Config.configMap.get("ZOMBIE_VILLAGER").getValue());
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void sheepDeath(Entity e) {
        Sheep sheep = (Sheep)e;
        double chance =  Config.configMap.get("SHEEP").getValue();

        switch (sheep.getColor()) {
            case BLACK:
                dropItem(e.getLocation(), MobHead.SHEEP_BLACK , chance);
                break;
            case WHITE:
                dropItem(e.getLocation(), MobHead.SHEEP_WHITE , chance);
                break;
            case BROWN:
                dropItem(e.getLocation(), MobHead.SHEEP_BROWN , chance);
                break;
            case GREEN:
                dropItem(e.getLocation(), MobHead.SHEEP_GREEN , chance);
                break;
            case CYAN:
                dropItem(e.getLocation(), MobHead.SHEEP_CYAN , chance);
                break;
            case BLUE:
                dropItem(e.getLocation(), MobHead.SHEEP_BLUE , chance);
                break;
            case RED:
                dropItem(e.getLocation(), MobHead.SHEEP_RED , chance);
                break;
            case GRAY:
                dropItem(e.getLocation(), MobHead.SHEEP_GRAY , chance);
                break;
            case LIME:
                dropItem(e.getLocation(), MobHead.SHEEP_LIME , chance);
                break;
            case PINK:
                dropItem(e.getLocation(), MobHead.SHEEP_PINK , chance);
                break;
            case ORANGE:
                dropItem(e.getLocation(), MobHead.SHEEP_ORANGE , chance);
                break;
            case PURPLE:
                dropItem(e.getLocation(), MobHead.SHEEP_PURPLE , chance);
                break;
            case YELLOW:
                dropItem(e.getLocation(), MobHead.SHEEP_YELLOW , chance);
                break;
            case MAGENTA:
                dropItem(e.getLocation(), MobHead.SHEEP_MAGENTA , chance);
                break;
            case LIGHT_BLUE:
                dropItem(e.getLocation(), MobHead.SHEEP_LIGHT_BLUE , chance);
                break;
            case LIGHT_GRAY:
                dropItem(e.getLocation(), MobHead.SHEEP_LIGHT_GRAY , chance);
                break;
        }
    }

    private void rabbitDeath(Entity e) {
        Rabbit rabbit = (Rabbit)e;
        double chance =  Config.configMap.get("RABBIT").getValue();

        switch (rabbit.getRabbitType()) {
            case BROWN:
                dropItem(e.getLocation(), MobHead.BROWN_RABBIT , chance);
                break;
            case WHITE:
                dropItem(e.getLocation(), MobHead.WHITE_RABBIT , chance);
                break;
            case BLACK:
                dropItem(e.getLocation(), MobHead.BLACK_RABBIT , chance);
                break;
            case GOLD:
                dropItem(e.getLocation(), MobHead.GOLD_RABBIT , chance);
                break;
            case BLACK_AND_WHITE:
                dropItem(e.getLocation(), MobHead.BLACK_AND_WHITE_RABBIT , chance);
                break;
            case SALT_AND_PEPPER:
                dropItem(e.getLocation(), MobHead.SALT_AND_PEPPER_RABBIT , chance);
                break;
            case THE_KILLER_BUNNY:
                dropItem(e.getLocation(), MobHead.THE_KILLER_BUNNY , chance);
                break;
        }
    }

    private void parrotDeath(Entity e) {
        Parrot parrot = (Parrot)e;
        double chance =  Config.configMap.get("PARROT").getValue();

        switch (parrot.getVariant()) {
            case GRAY:
                dropItem(e.getLocation(), MobHead.GRAY_PARROT , chance);
                break;
            case RED:
                dropItem(e.getLocation(), MobHead.RED_PARROT , chance);
                break;
            case BLUE:
                dropItem(e.getLocation(), MobHead.BLUE_PARROT , chance);
                break;
            case CYAN:
                dropItem(e.getLocation(), MobHead.CYAN_PARROT , chance);
                break;
            case GREEN:
                dropItem(e.getLocation(), MobHead.GREEN_PARROT , chance);
                break;
        }
    }

    private void pandaDeath(Entity e) {
        Panda panda = (Panda)e;
        double chance =  Config.configMap.get("PANDA").getValue();

        switch (panda.getMainGene()) {
            case BROWN:
                dropItem(e.getLocation(), MobHead.PANDA_BROWN , chance);
                break;
            case NORMAL:
                dropItem(e.getLocation(), MobHead.PANDA_PLAYFUL , chance);
                break;
            case LAZY:
                dropItem(e.getLocation(), MobHead.PANDA_LAZY , chance);
                break;
            case WEAK:
                dropItem(e.getLocation(), MobHead.PANDA_WORRIED , chance);
                break;
            case PLAYFUL:
                dropItem(e.getLocation(), MobHead.PANDA_PLAYFUL , chance);
                break;
            case WORRIED:
                dropItem(e.getLocation(), MobHead.PANDA_WORRIED , chance);
                break;
            case AGGRESSIVE:
                dropItem(e.getLocation(), MobHead.PANDA_AGRESSIVE , chance);
                break;
        }
    }

    private void llamaDeath(Entity e) {
        Llama llama = (Llama)e;
        double chance =  Config.configMap.get("LLAMA").getValue();

        switch (llama.getColor()) {
            case WHITE:
                dropItem(e.getLocation(), MobHead.WHITE_LLAMA , chance);
                break;
            case GRAY:
                dropItem(e.getLocation(), MobHead.GRAY_LLAMA , chance);
                break;
            case BROWN:
                dropItem(e.getLocation(), MobHead.BROWN_LLAMA , chance);
                break;
            case CREAMY:
                dropItem(e.getLocation(), MobHead.CREAMY_LLAMA , chance);
                break;
        }
    }

    private void horseDeath(Entity e) {
        Horse horse = (Horse)e;
        double chance =  Config.configMap.get("HORSE").getValue();

        switch (horse.getColor()) {
            case GRAY:
                dropItem(e.getLocation(), MobHead.GRAY_HORSE , chance);
                break;
            case BROWN:
                dropItem(e.getLocation(), MobHead.BROWN_HORSE , chance);
                break;
            case WHITE:
                dropItem(e.getLocation(), MobHead.CREAMY_HORSE , chance);
                break;
            case BLACK:
                dropItem(e.getLocation(), MobHead.BLACK_HORSE , chance);
                break;
            case CREAMY:
                dropItem(e.getLocation(), MobHead.WHITE_HORSE , chance);
                break;
            case CHESTNUT:
                dropItem(e.getLocation(), MobHead.CHESTNUT_HORSE , chance);
                break;
            case DARK_BROWN:
                dropItem(e.getLocation(), MobHead.DARK_BROWN_HORSE , chance);
                break;
        }
    }

    private void catDeath(Entity e) {
        Cat cat = (Cat)e;
        double chance =  Config.configMap.get("CAT").getValue();

        switch (cat.getCatType()) {
            case RED:
                dropItem(e.getLocation(), MobHead.GINGER_CAT ,chance);
                break;
            case BLACK:
                dropItem(e.getLocation(), MobHead.TUXEDO_CAT , chance);
                break;
            case TABBY:
                dropItem(e.getLocation(), MobHead.TABBY_CAT ,chance);
                break;
            case WHITE:
                dropItem(e.getLocation(), MobHead.WHITE_CAT , chance);
                break;
            case CALICO:
                dropItem(e.getLocation(), MobHead.CALICO_CAT ,chance);
                break;
            case JELLIE:
                dropItem(e.getLocation(), MobHead.JELLIE_CAT ,chance);
                break;
            case PERSIAN:
                dropItem(e.getLocation(), MobHead.PERSIAN_CAT ,chance);
                break;
            case RAGDOLL:
                dropItem(e.getLocation(), MobHead.RAGDOLL_CAT , chance);
                break;
            case SIAMESE:
                dropItem(e.getLocation(), MobHead.SIAMESE_CAT , chance);
                break;
            case ALL_BLACK:
                dropItem(e.getLocation(), MobHead.BLACK_CAT , chance);
                break;
            case BRITISH_SHORTHAIR:
                dropItem(e.getLocation(), MobHead.BRITISH_SHORTHAIR_CAT , chance);
                break;
        }
    }

    private void dropItem(Location location, MobHead type,double chance) {
        Random randomGenerator = new Random();
        double random = randomGenerator.nextDouble();

        if(random <= chance) {
          //  System.out.println("dropped");
           // System.out.println(random+"  "+chance);
            location.getWorld().dropItem(location,getTexturedSkull(type.getName(),type.getUrl()));
        }
    }

    private void dropItem(Location location,double chance,ItemStack drop,String type) {
        Random randomGenerator = new Random();
        double random = randomGenerator.nextDouble();

        if(random <= chance) {
            //  System.out.println("dropped");
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
