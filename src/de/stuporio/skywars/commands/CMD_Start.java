// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.commands;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.countdown.Countdown;
import de.stuporio.skywars.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CMD_Start implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        final Player p = (Player)sender;
        if (p.hasPermission("sw.start")) {
            if (!SkyWars.forcestarted) {
                p.sendMessage(Data.prefix + "Du hast das Spiel fr\u00fchzeitig gestartet");
                Countdown.forcestart();
            }else{
                p.sendMessage(Data.prefix + "Das Spiel kann §cnicht §7mehr frühzeitig gestartet werden!");
            }
        }
        return false;
    }
}
