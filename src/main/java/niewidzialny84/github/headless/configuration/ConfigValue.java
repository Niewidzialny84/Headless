package niewidzialny84.github.headless.configuration;

public class ConfigValue
{
    private final boolean drop;
    private final double chance;
    private final double looting;

    public ConfigValue(boolean drop, double chance, double looting)
    {
        this.drop = drop;
        this.chance = chance;
        this.looting = looting;
    }

    public boolean isDrop()
    {
        return drop;
    }

    public double getChance()
    {
        return chance;
    }

    public double getLooting()
    {
        return looting;
    }
}
