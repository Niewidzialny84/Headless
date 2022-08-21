package niewidzialny84.github.headless;

import niewidzialny84.github.headless.command.BasicCommands;
import niewidzialny84.github.headless.command.BasicCommandsTab;
import niewidzialny84.github.headless.listeners.MobDeathListener;
import niewidzialny84.github.headless.listeners.PlayerDeathListener;
import niewidzialny84.github.headless.configuration.Configuration;
import niewidzialny84.github.headless.utils.MetricsLite;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Headless extends JavaPlugin {
    private Configuration config;
    private PlayerDeathListener playerDeathListener;
    private MobDeathListener mobDeathListener;
    private BasicCommands basicCommand;
    private BasicCommandsTab basicCommandTab;


    @Override
    public void onEnable() {
        MetricsLite metricsLite = new MetricsLite(this);

        saveDefaultConfig();

        reload();

        basicCommand = new BasicCommands(this);
        basicCommandTab = new BasicCommandsTab(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reload()
    {
        this.getLogger().info("Reloading plugin...");

        HandlerList.unregisterAll(this);

        config = new Configuration(this);

        playerDeathListener = new PlayerDeathListener(this);
        mobDeathListener = new MobDeathListener(this);
    }

    public Configuration getConfiguration()
    {
        return config;
    }
}
