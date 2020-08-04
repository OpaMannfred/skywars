// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.commands;

import de.stuporio.core.utils.coins.CoinsAPI;
import de.stuporio.skywars.utils.Data;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CMD_Coins implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        final Player p = (Player)sender;
        p.sendMessage(Data.prefix + "Du hast §b" + CoinsAPI.getCoins(p.getUniqueId().toString()) + " Coins");
        return false;
    }
}
