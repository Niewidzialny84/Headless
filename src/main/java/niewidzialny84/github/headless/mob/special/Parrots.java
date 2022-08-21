package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.head.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Parrot.Variant;

public enum Parrots {
    GRAY(Variant.GRAY,MobHead.GRAY_PARROT),
    RED(Variant.RED,MobHead.RED_PARROT),
    BLUE(Variant.BLUE,MobHead.BLUE_PARROT),
    CYAN(Variant.CYAN,MobHead.CYAN_PARROT),
    GREEN(Variant.GREEN,MobHead.GREEN_PARROT),
    ;

    public final Variant variant;
    public final MobHead mobHead;

    Parrots(Variant variant, MobHead mobHead) {
        this.variant = variant;
        this.mobHead = mobHead;
    }

    public static Parrots getParrot(Entity entity) {
        Variant variant = ((org.bukkit.entity.Parrot)entity).getVariant();
        for(Parrots x : Parrots.values()) {
            if(variant.equals(x.variant)) {
                return x;
            }
        }
        return null;
    }
}
