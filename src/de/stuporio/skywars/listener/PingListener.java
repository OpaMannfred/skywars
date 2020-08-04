package de.stuporio.skywars.listener;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Developed
 * PingListener
 * by Max H.
 * at 26/05/2020
 */

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){
        if(SkyWars.state == GameState.LOBBY){
            e.setMotd("§0" + SkyWars.currentMap + " | Lobby");
        }else if(SkyWars.state == GameState.INGAME){
            e.setMotd("§0" + SkyWars.currentMap + " | Ingame");
        }
    }

}
