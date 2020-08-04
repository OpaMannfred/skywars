package de.stuporio.skywars.listener;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.listener.kits.KitsListener;
import de.stuporio.skywars.state.GameState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/***************************************************
 * Hinweise                                        
 * Copyright © Max H. 2020                          
 * Erstellt: 05.06.2020 / 08:41     
 **************************************************/

public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(SkyWars.state == GameState.ENDING || SkyWars.state == GameState.LOBBY){
            return;
        }

        if(p.getInventory().getBoots() == null){
            return;
        }

        if (!KitsListener.assasine.contains(p)) {
            return;
        }

        if(SkyWars.state == GameState.INGAME){
            if (KitsListener.assasine.contains(p)) {
                if(p.getInventory().getBoots().getType().equals(Material.DIAMOND_BOOTS)){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 250, 1, true));
                }
                if(p.getInventory().getBoots() == null || p.getInventory().getBoots().getType() != Material.DIAMOND_BOOTS){
                    if (p.hasPotionEffect(PotionEffectType.SPEED)) {
                        p.removePotionEffect(PotionEffectType.SPEED);
                    }
                }
            }
        }

    }

}
