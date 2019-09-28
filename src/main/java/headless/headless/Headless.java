package headless.headless;

import headless.headless.Commands.Basic;
import headless.headless.Commands.BasicTab;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Headless extends JavaPlugin {

    @Override
    public void onEnable() {
        MetricsLite metricsLite = new MetricsLite(this);
        saveDefaultConfig();

        Config.load(this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(this),this);
        this.getCommand("headless").setExecutor(new Basic(this));
        this.getCommand("headless").setTabCompleter(new BasicTab(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
