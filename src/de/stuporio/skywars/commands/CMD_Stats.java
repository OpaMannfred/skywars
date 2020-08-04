// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.Bukkit;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.SQLStats;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class CMD_Stats implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String s, final String[] args) {
        final Player p = (Player)sender;
        final double kills = SQLStats.getKills(p.getUniqueId().toString());
        final double deaths = SQLStats.getDeaths(p.getUniqueId().toString());
        final double wins = SQLStats.getWins(p.getUniqueId().toString());
        final double loses = SQLStats.getGames(p.getUniqueId().toString());
        final double KD = kills / deaths;
        final double WL = wins / loses;
        if (args.length == 0) {
            p.sendMessage(Data.prefix + "§8§m------------------------------");
            p.sendMessage(Data.prefix + "§7    ");
            p.sendMessage(Data.prefix + "§7Kills§8: §e" + SQLStats.getKills(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7Tode§8: §e" + SQLStats.getDeaths(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7K/D§8: §e" + KD);
            p.sendMessage(Data.prefix + "§7Rang§8: §e" + SQLStats.getRanking(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7    ");
            p.sendMessage(Data.prefix + "§7Spiele§8: §e" + SQLStats.getGames(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7Gewonnen§8: §e" + SQLStats.getWins(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7     ");
            p.sendMessage(Data.prefix + "§8§m------------------------------");
        }
        else if (args.length == 1) {
            final OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
            final double killst = SQLStats.getKills(t.getUniqueId().toString());
            final double deathst = SQLStats.getDeaths(t.getUniqueId().toString());
            final double winst = SQLStats.getWins(t.getUniqueId().toString());
            final double losest = SQLStats.getGames(t.getUniqueId().toString());
            final double KDt = killst / deathst;
            final double WLt = winst / losest;
            if (t != null) {
                p.sendMessage(Data.prefix + "§8§m------------------------------");
                p.sendMessage(Data.prefix + "§7    ");
                p.sendMessage(Data.prefix + "§7Kills§8: §e" + SQLStats.getKills(t.getUniqueId().toString()));
                p.sendMessage(Data.prefix + "§7Tode§8: §e" + SQLStats.getDeaths(t.getUniqueId().toString()));
                p.sendMessage(Data.prefix + "§7K/D§8: §e" + KDt);
                p.sendMessage(Data.prefix + "§7Rang§8: §e" + SQLStats.getRanking(t.getUniqueId().toString()));
                p.sendMessage(Data.prefix + "§7    ");
                p.sendMessage(Data.prefix + "§7Spiele§8: §e" + SQLStats.getGames(t.getUniqueId().toString()));
                p.sendMessage(Data.prefix + "§7Gewonnen§8: §e" + SQLStats.getWins(t.getUniqueId().toString()));
                p.sendMessage(Data.prefix + "§7     ");
                p.sendMessage(Data.prefix + "§8§m------------------------------");
            }
        }
        else {
            p.sendMessage(Data.prefix + "§8§m------------------------------");
            p.sendMessage(Data.prefix + "§7    ");
            p.sendMessage(Data.prefix + "§7Kills§8: §e" + SQLStats.getKills(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7Tode§8: §e" + SQLStats.getDeaths(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7K/D§8: §e" + KD);
            p.sendMessage(Data.prefix + "§7Rang§8: §e" + SQLStats.getRanking(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7    ");
            p.sendMessage(Data.prefix + "§7Spiele§8: §e" + SQLStats.getGames(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7Gewonnen§8: §e" + SQLStats.getWins(p.getUniqueId().toString()));
            p.sendMessage(Data.prefix + "§7     ");
            p.sendMessage(Data.prefix + "§8§m------------------------------");
        }
        return false;
    }
}
