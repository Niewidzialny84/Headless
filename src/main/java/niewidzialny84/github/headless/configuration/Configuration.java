package niewidzialny84.github.headless.configuration;

import niewidzialny84.github.headless.Headless;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Configuration
{
    private final Headless plugin;

    public Map<String, ConfigValue> configMap = new HashMap<>();

    public Configuration(Headless plugin)
    {
        this.plugin = plugin;

        readConfig();
    }

    public void readConfig() {
        plugin.reloadConfig();

        FileConfiguration config = plugin.getConfig();

        configMap.clear();

        Set<String> depth = config.getKeys(false);
        for(String x : depth) {
            boolean boolTmp = config.getBoolean(x+".drop",false);
            double doubleTmp = config.getDouble(x+".chance",5);
            double lootingTmp = config.getDouble(x+".looting",0);
            configMap.put(x,new ConfigValue(boolTmp, doubleTmp/100, lootingTmp/100));
        }
    }
}
