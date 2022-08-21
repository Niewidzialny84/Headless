package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.head.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Llama.Color;

public enum Llamas {
    WHITE(Color.WHITE,MobHead.WHITE_LLAMA),
    GRAY(Color.GRAY,MobHead.GRAY_LLAMA),
    BROWN(Color.BROWN,MobHead.BROWN_LLAMA),
    CREAMY(Color.CREAMY,MobHead.CREAMY_LLAMA),
    ;

    public final Color color;
    public final MobHead mobHead;

    Llamas(Color color, MobHead mobHead) {
        this.color = color;
        this.mobHead = mobHead;
    }

    public static Llamas getLlama(Entity entity) {
        Color color = ((org.bukkit.entity.Llama)entity).getColor();
        for(Llamas x : Llamas.values()) {
            if(color.equals(x.color)) {
                return x;
            }
        }
        return null;
    }
}
