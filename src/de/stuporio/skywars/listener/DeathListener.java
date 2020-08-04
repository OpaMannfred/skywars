// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.core.utils.coins.*;
import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.player.PlayerRespawnEvent;
import java.util.Random;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.GameMode;
import org.bukkit.Bukkit;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class DeathListener implements Listener
{
    public static HashMap<Player, Integer> roundkills;
    private static int task;
    private static int seconds;
    
    @EventHandler
    public void onDeath(final PlayerDeathEvent e) {
        final Player d = e.getEntity();
        final Player k = d.getKiller();
        Data.players.remove(d);
        if (Data.players.size() == 1 || Bukkit.getOnlinePlayers().size() == 1) {
            for (final Player all : Bukkit.getOnlinePlayers()) {
                all.teleport(LocationManager.getLocation("Lobby"));
                all.getInventory().clear();
                all.setGameMode(GameMode.SURVIVAL);
                all.getInventory().setArmorContents((ItemStack[])null);
            }
            start();
            final Player pd = Data.players.get(0);
            Bukkit.broadcastMessage(Data.prefix + "Der Spieler §e" + pd.getName() + " §7hat das Spiel gewonnen");
            SQLStats.addWins(pd.getUniqueId().toString(), 1);
        }
        if(k instanceof Player && k != null && k.getName() != d.getName()){

            if (!Manager.death.contains(d)) {
                e.setDeathMessage(Data.prefix + "Der Spieler §e" + d.getName() + " §7wurde von §6" + k.getName() + " §7getötet");
                SQLStats.addKills(k.getUniqueId().toString(), 1);
                SQLStats.addDeaths(d.getUniqueId().toString(), 1);
                CoinsAPI.addCoins(k.getUniqueId().toString(), this.getRandom(20, 100));
                de.stuporio.skywars.utils.api.CoinsAPI.addKills(k.getName(), 1);
                ScoreManager.update(k);
                ScoreManager.update(d);
                Data.players.remove(d);
            }

            Manager.death.remove(d);

            if (Data.players.size() == 1 || Bukkit.getOnlinePlayers().size() == 1) {
                start();
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    all.teleport(LocationManager.getLocation("Lobby"));
                    all.getInventory().clear();
                    all.setGameMode(GameMode.SURVIVAL);
                    all.getInventory().setArmorContents((ItemStack[])null);
                }
                CoinsAPI.addCoins(k.getUniqueId().toString(), this.getRandom(500, 1000));
            }
            else {
                Bukkit.broadcastMessage(Data.prefix + "Es verbleiben §e" + Data.players.size() + " §7Spieler");
            }

        }else{

            if (!Manager.death.contains(d)) {
                e.setDeathMessage(Data.prefix + "§6" + d.getName() + " §7ist gestorben");

                Manager.death.add(d);
                SQLStats.addDeaths(d.getUniqueId().toString(), 1);
                CoinsAPI.addCoins(k.getUniqueId().toString(), this.getRandom(10, 50));

                Bukkit.getScheduler().runTaskLater(SkyWars.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Manager.death.remove(d);
                    }
                }, 2);

            }

        }

    }
    
    public int getRandom(final int lower, final int upper) {
        final Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }
    
    @EventHandler
    public void onRe(final PlayerRespawnEvent e) {
        e.getPlayer().setGameMode(GameMode.SPECTATOR);
        if (e.getPlayer().getKiller() != null) {
            e.setRespawnLocation(e.getPlayer().getKiller().getLocation());
            Data.players.remove(e.getPlayer());
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        Player p = (Player) e.getEntity();
        Player k = (Player) e.getDamager();



    }
    
    public static void start() {
        DeathListener.task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin) SkyWars.getInstance(), (Runnable)new Runnable() {
            @Override
            public void run() {
                if (DeathListener.seconds == 10) {
                    Bukkit.broadcastMessage(Data.prefix + "Der Server startet in §6" + DeathListener.seconds + " §7Sekunden neu");
                    SkyWars.state = GameState.ENDING;
                }
                if (DeathListener.seconds == 5) {
                    Bukkit.broadcastMessage(Data.prefix + "Der Server startet in §6" + DeathListener.seconds + " §7Sekunden neu");
                }
                if (DeathListener.seconds == 4) {
                    Bukkit.broadcastMessage(Data.prefix + "Der Server startet in §6" + DeathListener.seconds + " §7Sekunden neu");
                }
                if (DeathListener.seconds == 3) {
                    Bukkit.broadcastMessage(Data.prefix + "Der Server startet in §6" + DeathListener.seconds + " §7Sekunden neu");
                }
                if (DeathListener.seconds == 2) {
                    Bukkit.broadcastMessage(Data.prefix + "Der Server startet in §6" + DeathListener.seconds + " §7Sekunden neu");
                }
                if (DeathListener.seconds == 1) {
                    Bukkit.broadcastMessage(Data.prefix + "Der Server startet in §6" + DeathListener.seconds + " §7Sekunden neu");
                }
                if (DeathListener.seconds == 0) {
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        all.kickPlayer("§4Der Server startet neu");
                    }
                    Bukkit.shutdown();
                    Bukkit.getScheduler().cancelTask(DeathListener.task);
                }
                DeathListener.seconds--;
            }
        }, 0L, 20L);
    }
    
    static {
        DeathListener.roundkills = new HashMap<Player, Integer>();
        DeathListener.seconds = 10;
    }
}
