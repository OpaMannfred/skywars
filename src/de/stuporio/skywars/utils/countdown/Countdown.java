// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils.countdown;

import de.dytanic.cloudnet.ext.bridge.bukkit.BukkitCloudNetBridgePlugin;
import de.dytanic.cloudnet.ext.bridge.bukkit.BukkitCloudNetHelper;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.LocationManager;
import de.stuporio.skywars.utils.ScoreManager;
import de.stuporio.skywars.utils.TitleAPI;
import org.bukkit.plugin.Plugin;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.listener.kits.KitsListener;
import org.bukkit.entity.Player;
import de.stuporio.skywars.SkyWars;
import org.bukkit.Bukkit;

public class Countdown
{
    public static int seconds;
    public static int task;
    private static int tpi;
    
    public static void forcestart() {
        Bukkit.getScheduler().cancelTask(Countdown.task);
        Countdown.seconds = 5;
        Countdown.task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)SkyWars.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (!Bukkit.getScheduler().isCurrentlyRunning(Countdown.task)) {
                    SkyWars.forcestarted = true;
                    if (Countdown.seconds == 5) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b5 §7Sekunden");
                    }
                    else if (Countdown.seconds == 4) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b4 §7Sekunden");
                    }
                    else if (Countdown.seconds == 3) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b3 §7Sekunden");
                    }
                    else if (Countdown.seconds == 2) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b2 §7Sekunden");
                    }
                    else if (Countdown.seconds == 1) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b1 §7Sekunden");
                    }
                    if (Countdown.seconds == 0) {
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.getInventory().clear();
                            all.closeInventory();
                            all.setHealth(20.0);
                            all.setFoodLevel(20);
                            Countdown.tpi++;
                            all.teleport(LocationManager.teleportToArena(Countdown.tpi));
                            Data.freeze.add(all);
                            all.setLevel(0);
                            KitsListener.setKits(all);
                            ScoreManager.update(all);
                        }
                        SkyWars.state = GameState.INGAME;
                        LaufCountdown.start();
                        Bukkit.getScheduler().cancelTask(Countdown.task);
                    }
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        TitleAPI.sendActionbar(all, Data.prefix + "Das Spiel beginnt in §b" + Countdown.seconds + " §7Sekunden");
                        all.setLevel(Countdown.seconds);
                    }
                    --Countdown.seconds;
                }
            }
        }, 0L, 20L);
    }
    
    public static void cancelAll() {
        Bukkit.getScheduler().cancelTask(Countdown.task);
    }
    
    public static void start() {
        Countdown.task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)SkyWars.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (!Bukkit.getScheduler().isCurrentlyRunning(Countdown.task)) {
                    if (Countdown.seconds == 30) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b30 §7Sekunden");
                    }
                    else if (Countdown.seconds == 20) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b20 §7Sekunden");
                    }
                    else if (Countdown.seconds == 10) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b10 §7Sekunden");
                    }
                    else if (Countdown.seconds == 5) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b5 §7Sekunden");
                    }
                    else if (Countdown.seconds == 4) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b4 §7Sekunden");
                    }
                    else if (Countdown.seconds == 3) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b3 §7Sekunden");
                    }
                    else if (Countdown.seconds == 2) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b2 §7Sekunden");
                    }
                    else if (Countdown.seconds == 1) {
                        Bukkit.broadcastMessage(Data.prefix + "Das Spiel startet in §b1 §7Sekunden");
                    }
                    if (Countdown.seconds == 0) {
                        SkyWars.state = GameState.INGAME;
                        BukkitCloudNetHelper.changeToIngame();
                        for (final Player all : Bukkit.getOnlinePlayers()) {
                            all.getInventory().clear();
                            all.closeInventory();
                            all.setHealth(20.0);
                            all.setFoodLevel(20);
                            Countdown.tpi++;
                            all.teleport(LocationManager.teleportToArena(Countdown.tpi));
                            Data.freeze.add(all);
                            all.setLevel(0);
                            KitsListener.setKits(all);
                            ScoreManager.update(all);
                        }
                        LaufCountdown.start();
                        Bukkit.getScheduler().cancelTask(Countdown.task);
                    }
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        TitleAPI.sendActionbar(all, Data.prefix + "Das Spiel beginnt in §b" + Countdown.seconds + " §7Sekunden");
                        all.setLevel(Countdown.seconds);
                    }
                    --Countdown.seconds;
                }
            }
        }, 0L, 20L);
    }
    
    static {
        Countdown.seconds = 30;
    }
}
