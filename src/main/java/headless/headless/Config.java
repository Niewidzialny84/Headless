package headless.headless;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javafx.util.Pair;

public abstract class Config {
    public static Map<String, Pair<Boolean,Double>> configMap;

    public static void load(Plugin plugin) {
        FileConfiguration config = plugin.getConfig();

        configMap = new HashMap<>();

        Set<String> depth = config.getKeys(false);
        for(String x : depth) {
            Boolean boolTmp = config.getBoolean(x+".drop",false);
            Double doubleTmp = config.getDouble(x+".chance",5);
            configMap.put(x,new Pair<>(boolTmp,doubleTmp/100));
        }
    }

}
