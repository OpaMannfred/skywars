// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils.countdown;

import de.stuporio.skywars.utils.ScoreManager;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.TitleAPI;
import org.bukkit.plugin.Plugin;
import de.stuporio.skywars.state.GameState;
import org.bukkit.entity.Player;
import de.stuporio.skywars.SkyWars;
import org.bukkit.Bukkit;

public class SchutzCountdown
{
    private static int task;
    private static int seconds;
    
    public static void start() {
        SchutzCountdown.task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)SkyWars.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (SchutzCountdown.seconds == 20) {
                    for(Player all : Bukkit.getOnlinePlayers()){
                        ScoreManager.update(all);
                    }
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                if (SchutzCountdown.seconds == 15) {
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                if (SchutzCountdown.seconds == 10) {
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                if (SchutzCountdown.seconds == 5) {
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                if (SchutzCountdown.seconds == 4) {
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                if (SchutzCountdown.seconds == 3) {
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                if (SchutzCountdown.seconds == 2) {
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                if (SchutzCountdown.seconds == 1) {
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit ist in §b" + SchutzCountdown.seconds + " §7vorbei");
                }
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    TitleAPI.sendActionbar(all, Data.prefix + "Die Schutzzeit endet in §b" + SchutzCountdown.seconds + " §7Sekunden");
                    all.setLevel(SchutzCountdown.seconds);
                }
                if (SchutzCountdown.seconds == 0) {
                    Bukkit.getScheduler().cancelTask(SchutzCountdown.task);
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        all.setLevel(0);
                    }
                    Bukkit.broadcastMessage(Data.prefix + "Die Schutzzeit endet §bjetzt");
                }
                SchutzCountdown.seconds--;
            }
        }, 0L, 20L);
    }
    
    static {
        SchutzCountdown.seconds = 20;
    }
}
