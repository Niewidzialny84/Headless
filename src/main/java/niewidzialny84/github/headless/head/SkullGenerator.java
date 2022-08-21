package niewidzialny84.github.headless.head;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class SkullGenerator
{
    public static ItemStack getTexturedSkull(String name, String encodedURL) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta headMeta = (SkullMeta) head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.fromString("e6583bd1-fc98-4fe9-a337-fe54c5de827b"), name);
        profile.getProperties().put("textures", new Property("textures", encodedURL));
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
