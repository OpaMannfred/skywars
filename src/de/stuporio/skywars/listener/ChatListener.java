// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.core.utils.coins.CoinsAPI;
import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;

public class ChatListener implements Listener
{
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        if (SkyWars.state == GameState.ENDING && e.getMessage().contains("gg") || e.getMessage().contains("GG") && !Data.gg.contains(e.getPlayer())) {
            e.getPlayer().sendMessage(Data.prefix + "Du hast §e20 Coins §7bekommen.");
            CoinsAPI.addCoins(e.getPlayer().getUniqueId().toString(), 20);
            Data.gg.add(e.getPlayer());
        }
    }
}
