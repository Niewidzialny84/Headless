package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse.Color;

public enum Horses {
    GRAY(Color.GRAY,MobHead.GRAY_HORSE),
    BROWN(Color.BROWN,MobHead.BROWN_HORSE),
    WHITE(Color.WHITE,MobHead.CREAMY_HORSE),
    BLACK(Color.BLACK,MobHead.BLACK_HORSE),
    CREAMY(Color.CREAMY,MobHead.WHITE_HORSE),
    CHESTNUT(Color.CHESTNUT,MobHead.CHESTNUT_HORSE),
    DARK_BROWN(Color.DARK_BROWN,MobHead.DARK_BROWN_HORSE),

    ;
    public Color color;
    public MobHead mobHead;

    Horses(Color color, MobHead mobHead) {
        this.color = color;
        this.mobHead = mobHead;
    }

    public static Horses getHorse(Entity entity) {
        Color color = ((org.bukkit.entity.Horse)entity).getColor();
        for(Horses x : Horses.values()) {
            if(color.equals(x.color)) {
                return x;
            }
        }
        return null;
    }
}
