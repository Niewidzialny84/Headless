package headless.headless.Commands;

import headless.headless.Config;
import headless.headless.DeathListener;
import headless.headless.MobHead;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

public class Basic implements CommandExecutor {

    private Plugin plugin;

    public Basic(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(commandSender != null && command != null && label != null) {
            if(commandSender instanceof Player && (commandSender.hasPermission("headless") || commandSender.isOp())) {
                if(args.length == 0 || args == null || args[0].equalsIgnoreCase("HELP")) {
                    printHelp(commandSender);
                    return true;
                }

                if(args[0].equalsIgnoreCase("RELOAD")) {
                    Config.load(plugin);
                    commandSender.sendMessage(ChatColor.DARK_AQUA+"Plugin reloaded succesfully");
                    return true;
                } else if(args[0].equalsIgnoreCase("GETHEAD")) {
                    if (args.length >= 2) {
                        MobHead[] heads = MobHead.values();
                        for (MobHead head : heads) {
                            if (args[1] != null && args[1].equalsIgnoreCase(head.name())) {
                                if (args.length == 3 && args[2] != null) {
                                    Collection<? extends Player> p = plugin.getServer().getOnlinePlayers();
                                    for (Player a : p) {
                                        if (args[2].equals(a.getName())) {
                                            a.getPlayer().getInventory().addItem(DeathListener.getTexturedSkull(head.getName(), head.getUrl()));
                                            a.getPlayer().playSound(a.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2, 0);
                                            return true;
                                        }
                                    }
                                    commandSender.sendMessage(ChatColor.DARK_AQUA + "Player " + ChatColor.AQUA + args[2] + ChatColor.DARK_AQUA + " not found");
                                    return true;
                                } else {
                                    ((Player) commandSender).getPlayer().getInventory().addItem(DeathListener.getTexturedSkull(head.getName(), head.getUrl()));
                                    ((Player) commandSender).getPlayer().playSound(((Player) commandSender).getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 2, 0);
                                    return true;
                                }
                            }
                        }
                        commandSender.sendMessage(ChatColor.DARK_AQUA+"Head not found");
                        return true;
                    } else if(args.length == 1) {
                        commandSender.sendMessage(ChatColor.DARK_AQUA+"Missing head name");
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("GETPLAYERHEAD")) {
                    if(args.length >= 2) {
                        if(args[1] != null) {
                            if(args.length == 3) {
                                Collection<? extends Player> p = plugin.getServer().getOnlinePlayers();
                                for (Player a : p) {
                                    if (args[2].equals(a.getName())) {
                                        a.getPlayer().getInventory().addItem(DeathListener.getPlayerHead(Bukkit.getOfflinePlayer(args[1])));
                                        a.getPlayer().playSound(a.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2, 0);
                                        return true;
                                    }
                                }
                                commandSender.sendMessage(ChatColor.DARK_AQUA + "Player " + ChatColor.AQUA + args[2] + ChatColor.DARK_AQUA + " not found");
                                return true;
                            } else {
                                ((Player) commandSender).getPlayer().getInventory().addItem(DeathListener.getPlayerHead(Bukkit.getOfflinePlayer(args[1])));
                                ((Player) commandSender).getPlayer().playSound(((Player) commandSender).getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 2, 0);
                                return true;
                            }
                        }
                    }else if(args.length == 1) {
                        commandSender.sendMessage(ChatColor.DARK_AQUA + "Missing player head name");
                        return true;
                    }
                } else {
                    printHelp(commandSender);
                    return true;
                }
            } else if(commandSender instanceof CommandSender) {
                if(args.length == 0 || args == null || args[0].equalsIgnoreCase("HELP")) {
                    printHelp(commandSender);
                    return true;
                }

                if(args[0].equalsIgnoreCase("RELOAD")) {
                    Config.load(plugin);
                    commandSender.sendMessage(ChatColor.DARK_AQUA + "Plugin reloaded succesfully");
                    return true;
                } else if(args[0].equalsIgnoreCase("GETHEAD")) {
                    if (args.length >= 2) {
                        MobHead[] heads = MobHead.values();
                        for (MobHead head : heads) {
                            if (args[1].equalsIgnoreCase(head.name()) && args[1] != null) {
                                if (args.length == 3 && args[2] != null) {
                                    Collection<? extends Player> p = plugin.getServer().getOnlinePlayers();
                                    for (Player a : p) {
                                        if (args[2].equals(a.getName())) {
                                            a.getPlayer().getInventory().addItem(DeathListener.getTexturedSkull(head.getName(), head.getUrl()));
                                            a.getPlayer().playSound(a.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2, 0);
                                            return true;
                                        }
                                    }
                                    commandSender.sendMessage(ChatColor.DARK_AQUA + "Player " + ChatColor.AQUA + args[2] + ChatColor.DARK_AQUA + " not found");
                                    return true;
                                }
                            }
                            else if(args.length == 2) {
                                commandSender.sendMessage(ChatColor.DARK_AQUA+"Missing player name");
                                return true;
                            }
                        }
                        commandSender.sendMessage(ChatColor.DARK_AQUA+"Head not found");
                        return true;
                    } else if(args.length == 1) {
                        commandSender.sendMessage(ChatColor.DARK_AQUA+"Missing head name");
                        return true;
                    } else {
                        printHelp(commandSender);
                        return true;
                    }
                } else if (args[0].equalsIgnoreCase("GETPLAYERHEAD")) {
                    if (args.length >= 2) {
                        if (args[1] != null) {
                            if (args.length == 3) {
                                Collection<? extends Player> p = plugin.getServer().getOnlinePlayers();
                                for (Player a : p) {
                                    if (args[2].equals(a.getName())) {
                                        a.getPlayer().getInventory().addItem(DeathListener.getPlayerHead(Bukkit.getOfflinePlayer(args[1])));
                                        a.getPlayer().playSound(a.getLocation(), Sound.ENTITY_ITEM_PICKUP, 2, 0);
                                        return true;
                                    }
                                }
                                commandSender.sendMessage(ChatColor.DARK_AQUA + "Player " + ChatColor.AQUA + args[2] + ChatColor.DARK_AQUA + " not found");
                                return true;
                            }
                        }
                        commandSender.sendMessage(ChatColor.DARK_AQUA + "Missing player name");
                        return true;
                    } else if (args.length == 1) {
                        commandSender.sendMessage(ChatColor.DARK_AQUA + "Missing player head name");
                        return true;
                    }
                }
                else {
                    printHelp(commandSender);
                    return true;
                }
            }
        }

        return false;
    }

    private void printHelp(CommandSender sender) {
        sender.sendMessage(ChatColor.DARK_AQUA+"Headless help:");
        sender.sendMessage(ChatColor.DARK_AQUA+"/headless reload"+ChatColor.GRAY+" - reloads plugin");
        sender.sendMessage(ChatColor.DARK_AQUA+"/headless gethead <head> <player>"+ChatColor.GRAY+" - gives head");
        sender.sendMessage(ChatColor.DARK_AQUA+"/headless getplayerhead <player_head> <player>"+ChatColor.GRAY+" - gives player head");

    }
}
