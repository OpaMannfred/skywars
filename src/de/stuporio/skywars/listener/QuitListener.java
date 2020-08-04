// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.ScoreManager;
import de.stuporio.skywars.utils.countdown.Countdown;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.Listener;

public class QuitListener implements Listener
{
    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        Data.players.remove(e.getPlayer());
        if (Bukkit.getOnlinePlayers().size() == 1 || Data.players.size() == 1 && SkyWars.state == GameState.LOBBY) {
            Countdown.cancelAll();
            SkyWars.starting = false;
            SkyWars.forcestarted = false;
            Bukkit.getScheduler().runTaskLater((Plugin) SkyWars.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    Countdown.cancelAll();
                }
            }, 1L);
        }
        if (SkyWars.state == GameState.INGAME || SkyWars.state == GameState.ENDING) {
            e.setQuitMessage(null);
            if (Data.players.size() == 1) {
                DeathListener.start();
            }
        }
        else {
            e.setQuitMessage((String)null);
        }
        if (SkyWars.state == GameState.LOBBY) {
            e.setQuitMessage(Data.prefix + "§6" + e.getPlayer().getName() + " §7hat den Server verlassen");
            for (final Player all : Bukkit.getOnlinePlayers()) {
                ScoreManager.update(all);
            }
        }
    }
}
