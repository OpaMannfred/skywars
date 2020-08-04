// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.commands;

import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.LocationManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CMD_Setloc implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("sw.setloc")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("lobby")) {
                    LocationManager.setLocation("Lobby", p.getLocation());
                    p.sendMessage(Data.prefix + "Du hast die §bLobby §7gesetzt");
                }
            }
            else {
                p.sendMessage(Data.prefix + "/setloc [lobby]");
            }
        }
        return false;
    }
}
