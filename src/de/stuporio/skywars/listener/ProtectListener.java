// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.Data;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.EventHandler;
import de.stuporio.skywars.SkyWars;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.Listener;

public class ProtectListener implements Listener
{
    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        if (Data.builder.contains(e.getPlayer())) {
            return;
        }
        if (SkyWars.state == GameState.LOBBY) {
            e.setCancelled(true);
        }
        else if (SkyWars.state == GameState.INGAME) {
            e.setCancelled(false);
        }
        else if (SkyWars.state == GameState.ENDING) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onFood(final FoodLevelChangeEvent e) {
        if (SkyWars.state == GameState.LOBBY) {
            e.setCancelled(true);
        }
        else if (SkyWars.state == GameState.INGAME) {
            e.setCancelled(false);
        }
        else if (SkyWars.state == GameState.ENDING) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDamage(final EntityDamageEvent e) {
        if (SkyWars.state == GameState.LOBBY) {
            e.setCancelled(true);
        }
        else if (SkyWars.state == GameState.ENDING) {
            e.setCancelled(true);
        }
        else if (SkyWars.state == GameState.INGAME) {
            e.setCancelled(false);
        }
    }
    
    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        if (Data.builder.contains(e.getPlayer())) {
            return;
        }
        if (SkyWars.state == GameState.LOBBY) {
            e.setCancelled(true);
        }
        else if (SkyWars.state == GameState.INGAME) {
            e.setCancelled(false);
        }
        else if (SkyWars.state == GameState.ENDING) {
            e.setCancelled(true);
        }
    }
}
