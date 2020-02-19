package niewidzialny84.github.headless.mob.special;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Panda.Gene;

public enum Panda {
    BROWN(Gene.BROWN, MobHead.PANDA_BROWN),
    NORMAL(Gene.NORMAL, MobHead.PANDA_PLAYFUL),
    LAZY(Gene.LAZY, MobHead.PANDA_LAZY),
    WEAK(Gene.WEAK, MobHead.PANDA_WORRIED),
    PLAYFUL(Gene.PLAYFUL, MobHead.PANDA_PLAYFUL),
    WORRIED(Gene.WORRIED, MobHead.PANDA_WORRIED),
    AGGRESSIVE(Gene.AGGRESSIVE, MobHead.PANDA_AGRESSIVE),
    ;

    public Gene gene;
    public MobHead mobHead;

    Panda(Gene gene, MobHead mobHead) {
        this.gene = gene;
        this.mobHead = mobHead;
    }

    public static Panda getPanda(Entity entity) {
        Gene gene = ((org.bukkit.entity.Panda)entity).getMainGene();
        for(Panda x : Panda.values()) {
            if(gene.equals(x.gene)) {
                return x;
            }
        }
        return null;
    }
}
