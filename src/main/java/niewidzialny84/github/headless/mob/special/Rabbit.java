package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Rabbit.Type;

public enum Rabbit {
    BROWN(Type.BROWN,MobHead.BROWN_RABBIT),
    WHITE(Type.WHITE,MobHead.WHITE_RABBIT),
    BLACK(Type.BLACK,MobHead.BLACK_RABBIT),
    GOLD(Type.GOLD,MobHead.GOLD_RABBIT),
    BLACK_AND_WHITE(Type.BLACK_AND_WHITE,MobHead.BLACK_AND_WHITE_RABBIT),
    SALT_AND_PEPPER(Type.SALT_AND_PEPPER,MobHead.SALT_AND_PEPPER_RABBIT),
    THE_KILLER_BUNNY(Type.THE_KILLER_BUNNY,MobHead.THE_KILLER_BUNNY),
    ;

    public Type type;
    public MobHead mobHead;

    Rabbit(Type type, MobHead mobHead) {
        this.type = type;
        this.mobHead = mobHead;
    }

    public static Rabbit getRabbit(Entity entity) {
        Type type = ((org.bukkit.entity.Rabbit)entity).getRabbitType();
        for(Rabbit x : Rabbit.values()) {
            if(type.equals(x.type)) {
                return x;
            }
        }
        return null;
    }
}
