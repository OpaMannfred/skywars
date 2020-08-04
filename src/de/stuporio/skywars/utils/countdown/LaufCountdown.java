// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils.countdown;

import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.TitleAPI;
import org.bukkit.Sound;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import de.stuporio.skywars.SkyWars;
import org.bukkit.Bukkit;

public class LaufCountdown
{
    private static int task;
    private static int seconds;
    
    public static void start() {
        LaufCountdown.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyWars.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (LaufCountdown.seconds == 3) {
                    Bukkit.broadcastMessage(Data.prefix + "Du kannst dich in §b" + LaufCountdown.seconds + " §7Sekunden bewegen");
                    for(Player all : Bukkit.getOnlinePlayers()){
                        TitleAPI.sendTitle(all, 20, 20, 20, "§43", null);
                        all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
                    }
                }
                if (LaufCountdown.seconds == 2) {
                    Bukkit.broadcastMessage(Data.prefix + "Du kannst dich in §b" + LaufCountdown.seconds + " §7Sekunden bewegen");
                    for(Player all : Bukkit.getOnlinePlayers()){
                        TitleAPI.sendTitle(all, 20, 20, 20, "§c2", null);
                        all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
                    }
                }
                if (LaufCountdown.seconds == 1) {
                    Bukkit.broadcastMessage(Data.prefix + "Du kannst dich §bjetzt §7bewegen");
                    Bukkit.getScheduler().cancelTask(LaufCountdown.task);
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        Data.freeze.remove(all);
                        TitleAPI.sendTitle(all, 20, 20, 20, "§a1", null);
                        all.playSound(all.getLocation(), Sound.NOTE_BASS, 1, 1);
                    }
                    SchutzCountdown.start();
                }
                LaufCountdown.seconds--;
            }
        }, 0L, 20L);
    }
    
    static {
        LaufCountdown.seconds = 3;
    }
}
