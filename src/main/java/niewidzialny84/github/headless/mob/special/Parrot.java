package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Parrot.Variant;

public enum Parrot {
    GRAY(Variant.GRAY,MobHead.GRAY_PARROT),
    RED(Variant.RED,MobHead.RED_PARROT),
    BLUE(Variant.BLUE,MobHead.BLUE_PARROT),
    CYAN(Variant.CYAN,MobHead.CYAN_PARROT),
    GREEN(Variant.GREEN,MobHead.GREEN_PARROT),
    ;

    public Variant variant;
    public MobHead mobHead;

    Parrot(Variant variant, MobHead mobHead) {
        this.variant = variant;
        this.mobHead = mobHead;
    }

    public static Parrot getParrot(Entity entity) {
        Variant variant = ((org.bukkit.entity.Parrot)entity).getVariant();
        for(Parrot x : Parrot.values()) {
            if(variant.equals(x.variant)) {
                return x;
            }
        }
        return null;
    }
}
