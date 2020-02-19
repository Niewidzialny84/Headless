package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Llama.Color;

public enum Llama {
    WHITE(Color.WHITE,MobHead.WHITE_LLAMA),
    GRAY(Color.GRAY,MobHead.GRAY_LLAMA),
    BROWN(Color.BROWN,MobHead.BROWN_LLAMA),
    CREAMY(Color.CREAMY,MobHead.CREAMY_LLAMA),
    ;

    public Color color;
    public MobHead mobHead;

    Llama(Color color, MobHead mobHead) {
        this.color = color;
        this.mobHead = mobHead;
    }

    public static Llama getLlama(Entity entity) {
        Color color = ((org.bukkit.entity.Llama)entity).getColor();
        for(Llama x : Llama.values()) {
            if(color.equals(x.color)) {
                return x;
            }
        }
        return null;
    }
}
