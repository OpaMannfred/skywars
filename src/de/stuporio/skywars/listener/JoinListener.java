// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.core.utils.tablist.TablistAPI;
import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.*;
import de.stuporio.skywars.utils.countdown.Countdown;
import org.bukkit.event.EventHandler;
import org.bukkit.Material;
import org.bukkit.GameMode;
import de.stuporio.skywars.listener.kits.KitsListener;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;
import org.bukkit.event.Listener;

public class JoinListener implements Listener
{
    List list = SkyWars.cfg.getStringList("Maps");
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        ScoreManager.setScoreboard(p);
        p.setPlayerWeather(WeatherType.CLEAR);
        p.setPlayerTime(6000L, true);

        if(!SkyWars.mySQL.isConnected()){
            SkyWars.mySQL.connect();
        }

        new TablistAPI().setDefaults();

        if (list.isEmpty()) {
            p.sendMessage(Data.prefix + "§7Willkommen im Setup von SkyWars");
            p.sendMessage(Data.prefix + "Schreibe in den Chat den namen der SkyWars-Map");
            p.sendMessage(Data.prefix + "§4§lACHTUNG!! §7Der Name darf nur ein Wort sein");
        }
        Bukkit.getScheduler().runTaskLater(SkyWars.getInstance(), new Runnable() {
            @Override
            public void run() {
                p.teleport(LocationManager.getLocation("Lobby"));
            }
        }, 5L);

        if (!SQLStats.playerExists(p.getUniqueId().toString())) {
            SQLStats.createPlayer(p.getUniqueId().toString());
        }
        if (!SQLKits.playerExists(p.getUniqueId().toString())) {
            SQLKits.createPlayer(p.getUniqueId().toString());
        }
        if (SkyWars.state == GameState.LOBBY) {
            KitsListener.starter.add(p);
            if (!Data.players.contains(p)) {
                SQLStats.addGames(p.getUniqueId().toString(), 1);
            }
            Data.players.add(p);
            if (LocationManager.locationIsExisting("Lobby")) {
                p.teleport(LocationManager.getLocation("Lobby"));
                ScoreManager.update(p);
                Bukkit.getScheduler().runTaskLater((Plugin)SkyWars.getInstance(), (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        p.teleport(LocationManager.getLocation("Lobby"));
                    }
                }, 5L);
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    ScoreManager.update(all);
                }
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.setGameMode(GameMode.SURVIVAL);
                if (p.hasPermission("sw.admin")) {
                    p.getInventory().setItem(4, new ItemManager(Material.COMMAND).setDisplayName("§8» §cOptionen").build());
                    p.getInventory().setItem(2, new ItemManager(Material.CHEST).setDisplayName("§8» §cKits").build());
                    p.getInventory().setItem(6, new ItemManager(Material.GLOWSTONE_DUST).setDisplayName("§8» §cVerlassen").build());
                    p.setHealth(20.0);
                    p.setFoodLevel(20);
                }
                else {
                    p.getInventory().setItem(2, new ItemManager(Material.CHEST).setDisplayName("§8» §cKits").build());
                    p.getInventory().setItem(6, new ItemManager(Material.GLOWSTONE_DUST).setDisplayName("§8» §cVerlassen").build());
                }
                e.setJoinMessage(Data.prefix + "§6" + p.getName() + " §7hat den Server betreten");
                if (Bukkit.getOnlinePlayers().size() >= 2) {
                    if (!SkyWars.starting) {
                        SkyWars.starting = true;
                        Countdown.start();
                    }
                    else {
                        p.sendMessage("");
                    }
                }
                if (Bukkit.getOnlinePlayers().size() == 8) {
                    p.kickPlayer("§4Die Runde ist voll");
                }
            }
        }
        if (SkyWars.state == GameState.ENDING || SkyWars.state == GameState.INGAME) {
            p.setGameMode(GameMode.SPECTATOR);
            Data.spectator.add(p);
            p.teleport(Data.players.get(Utils.rndInt(1,2)));
            e.setJoinMessage((String)null);
        }
    }
}
