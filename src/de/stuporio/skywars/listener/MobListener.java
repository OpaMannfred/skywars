package de.stuporio.skywars.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

/***************************************************
 * Hinweise                                        
 * Copyright © Max H. 2020                          
 * Erstellt: 05.06.2020 / 14:34     
 **************************************************/

public class MobListener implements Listener {

    @EventHandler
    public void onMob(CreatureSpawnEvent e){
        e.setCancelled(true);
    }

}
