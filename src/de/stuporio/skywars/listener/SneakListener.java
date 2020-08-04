package de.stuporio.skywars.listener;

import de.stuporio.skywars.utils.ScoreManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/***************************************************
 * Hinweise                                        
 * Copyright © Max H. 2020                          
 * Erstellt: 05.06.2020 / 09:15     
 **************************************************/

public class SneakListener implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent e){
        Player p = e.getPlayer();
        ScoreManager.update(p);
    }

}
