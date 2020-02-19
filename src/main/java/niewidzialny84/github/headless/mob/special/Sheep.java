package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;

public enum Sheep {
    BLACK(DyeColor.BLACK,MobHead.SHEEP_BLACK),
    WHITE(DyeColor.WHITE,MobHead.SHEEP_WHITE),
    BROWN(DyeColor.BROWN,MobHead.SHEEP_BROWN),
    GREEN(DyeColor.GREEN,MobHead.SHEEP_GREEN),
    CYAN(DyeColor.CYAN,MobHead.SHEEP_CYAN),
    BLUE(DyeColor.BLUE,MobHead.SHEEP_BLUE),
    RED(DyeColor.RED,MobHead.SHEEP_RED),
    GRAY(DyeColor.GRAY,MobHead.SHEEP_GRAY),
    LIME(DyeColor.LIME,MobHead.SHEEP_LIME),
    PINK(DyeColor.PINK,MobHead.SHEEP_PINK),
    ORANGE(DyeColor.ORANGE,MobHead.SHEEP_ORANGE),
    PURPLE(DyeColor.PURPLE,MobHead.SHEEP_PURPLE),
    YELLOW(DyeColor.YELLOW,MobHead.SHEEP_YELLOW),
    MAGENTA(DyeColor.MAGENTA,MobHead.SHEEP_MAGENTA),
    LIGHT_BLUE(DyeColor.LIGHT_BLUE,MobHead.SHEEP_LIGHT_BLUE),
    LIGHT_GRAY(DyeColor.LIGHT_GRAY,MobHead.SHEEP_LIGHT_GRAY),
    ;

    public DyeColor color;
    public MobHead mobHead;

    Sheep(DyeColor color, MobHead mobHead) {
        this.color = color;
        this.mobHead = mobHead;
    }

    public static Sheep getSheep(Entity entity) {
        DyeColor color = ((org.bukkit.entity.Sheep)entity).getColor();
        for(Sheep x : Sheep.values()) {
            if(color.equals(x.color)) {
                return x;
            }
        }
        return null;
    }
}
