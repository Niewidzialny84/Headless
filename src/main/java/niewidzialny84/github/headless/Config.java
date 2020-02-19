package niewidzialny84.github.headless;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Config {
    public static Map<String, Pair> configMap = new HashMap<>();

    public static void load(Plugin plugin) {
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();

        configMap.clear();

        Set<String> depth = config.getKeys(false);
        for(String x : depth) {
            Boolean boolTmp = config.getBoolean(x+".drop",false);
            Double doubleTmp = config.getDouble(x+".chance",5);
            configMap.put(x,new Pair(boolTmp,doubleTmp/100));
        }
    }
}
