// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.commands;

import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.listener.Setup;
import de.stuporio.skywars.SkyWars;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CMD_Addmap implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("sw.addmap")) {
            SkyWars.isChat = true;
            Setup.setup = 2;
            p.sendMessage(Data.prefix + "Schreibe nun den Map name in den Chat");
        }
        return false;
    }
}
