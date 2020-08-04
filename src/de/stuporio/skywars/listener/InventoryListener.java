package de.stuporio.skywars.listener;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/***************************************************
 * Hinweise                                        
 * Copyright © Max H. 2020                          
 * Erstellt: 05.06.2020 / 13:46     
 **************************************************/

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();

        if(SkyWars.state == GameState.LOBBY || SkyWars.state == GameState.ENDING){
            if (e.getInventory() == p.getInventory()) {
                e.setCancelled(true);
            }
        }


    }

}
