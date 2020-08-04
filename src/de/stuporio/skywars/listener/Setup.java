// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.LocationManager;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

import java.io.IOException;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;
import org.bukkit.event.Listener;

public class Setup implements Listener
{
    public static int setup;
    String map;
    List list;
    
    public Setup() {
        this.list = SkyWars.cfg.getStringList("Maps");
    }
    
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (SkyWars.isChat) {
            if (Setup.setup == 2) {
                if (!list.contains(e.getMessage())) {
                    list.add(e.getMessage());
                    SkyWars.cfg.set("Maps", list);
                    p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#1 §7mit 'gesetzt'");
                    this.map = e.getMessage();
                    SkyWars.g1 = true;
                    try {
                        SkyWars.cfg.save(SkyWars.file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    setup++;
                }
                else {
                    p.sendMessage(Data.prefix + "Diese Karte existiert schon");
                }
            }
            else if (Setup.setup == 3) {
                if (SkyWars.g1) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".1", p.getLocation());
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#2 §7mit 'gesetzt'");
                        SkyWars.g1 = false;
                        SkyWars.g2 = true;
                        p.sendMessage(Data.prefix + "Spawn §5#1 §7gesetzt");
                    }
                }
                else if (SkyWars.g2) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".2", p.getLocation());
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#3 §7mit 'gesetzt'");
                        SkyWars.g2 = false;
                        SkyWars.g3 = true;
                        p.sendMessage(Data.prefix + "Spawn §5#2 §7gesetzt");
                    }
                }
                else if (SkyWars.g3) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".3", p.getLocation());
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#4 §7mit 'gesetzt'");
                        SkyWars.g3 = false;
                        SkyWars.g4 = true;
                        p.sendMessage(Data.prefix + "Spawn §5#3 §7gesetzt");
                    }
                }
                else if (SkyWars.g4) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".4", p.getLocation());
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#5 §7mit 'gesetzt'");
                        SkyWars.g4 = false;
                        SkyWars.g5 = true;
                        p.sendMessage(Data.prefix + "Spawn §5#4 §7gesetzt");
                    }
                }
                else if (SkyWars.g5) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".5", p.getLocation());
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#6 §7mit 'gesetzt'");
                        SkyWars.g5 = false;
                        SkyWars.g6 = true;
                        p.sendMessage(Data.prefix + "Spawn §5#5 §7gesetzt");
                    }
                }
                else if (SkyWars.g6) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".6", p.getLocation());
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#7 §7mit 'gesetzt'");
                        SkyWars.g6 = false;
                        SkyWars.g7 = true;
                        p.sendMessage(Data.prefix + "Spawn §5#6 §7gesetzt");
                    }
                }
                else if (SkyWars.g7) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".7", p.getLocation());
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §b#8 §7mit 'gesetzt'");
                        SkyWars.g7 = false;
                        SkyWars.g8 = true;
                        p.sendMessage(Data.prefix + "Spawn §5#7 §7gesetzt");
                    }
                }
                else if (SkyWars.g8) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".8", p.getLocation());
                        SkyWars.gSpec = true;
                        SkyWars.g8 = false;
                        p.sendMessage(Data.prefix + "Setze nun den Spawn von §bSpectator §7mit 'gesetzt'");
                        p.sendMessage(Data.prefix + "Spawn §5#8 §7gesetzt");
                    }
                }
                else if (SkyWars.gSpec) {
                    if (e.getMessage().equalsIgnoreCase("gesetzt")) {
                        LocationManager.setLocation(this.map + ".Spectator", p.getLocation());
                        if (!LocationManager.locationIsExisting("Lobby")) {
                            p.sendMessage(Data.prefix + "Setze nun den Spawn von §bLobby §7mit 'gesetzt'");
                            SkyWars.gSpec = false;
                            SkyWars.gLobby = true;
                        }
                        else {
                            p.kickPlayer("§b§lSkyWars §7ist nun Spielbar");
                        }
                        p.sendMessage(Data.prefix + "Spawn f\u00fcr die §bSpectator §7gesetzt");
                    }
                }
                else if (SkyWars.gLobby && e.getMessage().equalsIgnoreCase("gesetzt")) {
                    LocationManager.setLocation("Lobby", p.getLocation());
                    SkyWars.gLobby = false;
                    SkyWars.gSpec = false;
                    p.kickPlayer("§8§m----------------------\n§b§lSkyWars §7ist nun Spielbar\n§8§m----------------------");
                    Bukkit.reload();
                    p.sendMessage(Data.prefix + "Spawn §bLobby §7gesetzt");
                }
            }
        }
    }
    
    static {
        Setup.setup = 0;
    }
}
