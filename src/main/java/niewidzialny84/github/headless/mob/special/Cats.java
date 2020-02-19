package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.entity.Cat.Type;
import org.bukkit.entity.Entity;

public enum Cats {
    RED(Type.RED,MobHead.GINGER_CAT),
    BLACK(Type.BLACK,MobHead.TUXEDO_CAT),
    TABBY(Type.TABBY,MobHead.TABBY_CAT),
    WHITE(Type.WHITE,MobHead.WHITE_CAT),
    CALICO(Type.CALICO,MobHead.CALICO_CAT),
    JELLIE(Type.JELLIE,MobHead.JELLIE_CAT),
    PERSIAN(Type.PERSIAN,MobHead.PERSIAN_CAT),
    RAGDOLL(Type.RAGDOLL,MobHead.RAGDOLL_CAT),
    SIAMESE(Type.SIAMESE,MobHead.SIAMESE_CAT),
    ALL_BLACK(Type.ALL_BLACK,MobHead.BLACK_CAT),
    BRITISH_SHORTHAIR(Type.BRITISH_SHORTHAIR,MobHead.BRITISH_SHORTHAIR_CAT),
    ;

    public Type type;
    public MobHead mobhead;

    Cats(Type type, MobHead mobhead) {
        this.type = type;
        this.mobhead = mobhead;
    }

    public static Cats getCat(Entity entity) {
        Type type = ((org.bukkit.entity.Cat)entity).getCatType();
        for(Cats x : Cats.values()) {
            if(type.equals(x.type)) {
                return x;
            }
        }
        return null;
    }
}
