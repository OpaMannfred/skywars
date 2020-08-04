// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.commands;

import de.stuporio.skywars.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CMD_Build implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("sw.build")) {
            if (Data.builder.contains(p)) {
                Data.builder.remove(p);
                p.sendMessage(Data.prefix + "Du bist nun nicht mehr im §bBuild-Modus");
            }
            else {
                Data.builder.add(p);
                p.sendMessage(Data.prefix + "Du bist nun im §bBuild-Modus");
            }
        }
        return false;
    }
}
