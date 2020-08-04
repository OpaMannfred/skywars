// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.commands;

import java.util.List;

import de.stuporio.skywars.utils.ScoreManager;
import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CMD_Forcemap implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String lbl, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("sw.forcemap")) {
            if (args.length == 0) {
                for (final String s : SkyWars.cfg.getStringList("Maps")) {
                    p.sendMessage(Data.prefix + "§7Karte §8| §b" + s);
                }
            } else if (args.length == 1) {
                final List list = SkyWars.cfg.getStringList("Maps");
                if (list.contains(args[0])) {
                    p.sendMessage(Data.prefix + "Du hast die Karte zu §b" + args[0] + " §7ge\u00e4ndert");
                    SkyWars.currentMap = args[0];
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        ScoreManager.update(all);
                    }
                }
            }
        }
        return false;
    }
}
