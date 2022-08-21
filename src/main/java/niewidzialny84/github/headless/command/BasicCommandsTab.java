package niewidzialny84.github.headless.command;

import niewidzialny84.github.headless.Headless;
import niewidzialny84.github.headless.head.MobHead;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BasicCommandsTab implements TabCompleter {
    private final static List<String> EMPTY = new ArrayList<>();
    private List<String> SUB = Arrays.asList("help","reload","gethead","getplayerhead");
    private List<String> HEAD = new ArrayList<>();
    private List<String> PLAYERS = new ArrayList<>();

    public BasicCommandsTab(Headless plugin) {
        MobHead[] heads = MobHead.values();
        for(MobHead head : heads) {
            HEAD.add(head.name());
        }

        Collection<? extends Player> p = plugin.getServer().getOnlinePlayers();
        for (Player a : p) {
            PLAYERS.add(a.getName());
        }

        plugin.getCommand("headless").setTabCompleter(this);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getLabel().equalsIgnoreCase(alias)) {
            if(args.length == 0) {
                return SUB;
            } else if(args.length == 1) {
                return SUB;
            } else if(args.length == 2) {
                if(args[0].equalsIgnoreCase("GETHEAD")) {
                    return HEAD;
                } else if(args[0].equalsIgnoreCase("GETPLAYERHEAD")) {
                    return null;
                }
            } else if (args.length == 3) {
                if(args[0].equalsIgnoreCase("GETHEAD")) {
                    if(HEAD.contains(args[1])) {
                        return null;
                    }
                } else if(args[0].equalsIgnoreCase("GETPLAYERHEAD")) {
                    return null;
                }
            }
            return EMPTY;
        }
        return EMPTY;
    }
}
