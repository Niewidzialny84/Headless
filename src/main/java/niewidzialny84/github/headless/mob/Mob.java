package niewidzialny84.github.headless.mob;

import niewidzialny84.github.headless.MobHead;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public enum Mob {
    BAT(EntityType.BAT,MobHead.BAT),
    BEE(EntityType.BEE,MobHead.BEE),
    BLAZE(EntityType.BLAZE,MobHead.BLAZE),
    CAVE_SPIDER(EntityType.CAVE_SPIDER,MobHead.CAVE_SPIDER),
    CHICKEN(EntityType.CHICKEN,MobHead.CHICKEN),
    COW(EntityType.COW,MobHead.COW),
    DROWNED(EntityType.DROWNED,MobHead.DROWNED),
    DOLPHIN(EntityType.DOLPHIN,MobHead.DOLPHIN),
    ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN,MobHead.ELDER_GUARDIAN),
    ENDERMAN(EntityType.ENDERMAN,MobHead.ENDERMAN),
    EVOKER(EntityType.EVOKER,MobHead.EVOKER),
    FOX(EntityType.FOX,MobHead.FOX),
    GHAST(EntityType.GHAST,MobHead.GHAST),
    GUARDIAN(EntityType.GUARDIAN,MobHead.GUARDIAN),
    HUSK(EntityType.HUSK,MobHead.HUSK),
    IRON_GOLEM(EntityType.IRON_GOLEM,MobHead.IRON_GOLEM),
    MAGMA_CUBE(EntityType.MAGMA_CUBE,MobHead.MAGMA_CUBE),
    MUSHROOM_COW(EntityType.MUSHROOM_COW,MobHead.MUSHROOM_COW),
    OCELOT(EntityType.OCELOT,MobHead.OCELOT),
    PHANTOM(EntityType.PHANTOM,MobHead.PHANTOM),
    PIG(EntityType.PIG,MobHead.PIG),
    //TODO: Add more new added mobs/fix old ones
    //PIG_ZOMBIE(EntityType.PIG_ZOMBIE,MobHead.PIG_ZOMBIE),
    PILLAGER(EntityType.PILLAGER,MobHead.PILLAGER),
    POLAR_BEAR(EntityType.POLAR_BEAR,MobHead.POLAR_BEAR),
    RAVAGER(EntityType.RAVAGER,MobHead.RAVAGER),
    SHULKER(EntityType.SHULKER,MobHead.SHULKER),
    SLIME(EntityType.SLIME,MobHead.SLIME),
    SQUID(EntityType.SQUID,MobHead.SQUID),
    SPIDER(EntityType.SPIDER,MobHead.SPIDER),
    SNOWMAN(EntityType.SNOWMAN,MobHead.SNOWMAN),
    TURTLE(EntityType.TURTLE,MobHead.TURTLE),
    VINDICATOR(EntityType.VINDICATOR,MobHead.VINDICATOR),
    VEX(EntityType.VEX,MobHead.VEX),
    WITCH(EntityType.WITCH,MobHead.WITCH),
    WITHER(EntityType.WITHER,MobHead.WITHER),
    WOLF(EntityType.WOLF,MobHead.WOLF),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER,MobHead.ZOMBIE_VILLAGER);

    public EntityType entity;
    public MobHead mobHead;

    Mob(EntityType entity, MobHead mobHead) {
        this.entity = entity;
        this.mobHead = mobHead;
    }
}
