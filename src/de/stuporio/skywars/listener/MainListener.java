// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.ItemManager;
import de.stuporio.skywars.utils.ScoreManager;
import de.stuporio.skywars.utils.countdown.Countdown;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.Listener;

public class MainListener implements Listener
{
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        if (Data.freeze.contains(e.getPlayer())) {
            final Player p = e.getPlayer();
            final Location to = e.getTo();
            final Location from = e.getFrom();
            if (from.getX() != to.getX() || from.getZ() != to.getZ()) {
                p.teleport(from);
            }
        }
    }
    
    @EventHandler
    public void onInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (e.getItem() == null) {
            return;
        }
        if (e.getItem().getItemMeta() == null) {
            return;
        }
        if (e.getItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cOptionen")) {

            Inventory inv = Bukkit.createInventory(null, 9*3, "§eOptionen");

            for(int i = 0; i < inv.getSize(); i++)
                inv.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());

            inv.setItem(11, new ItemManager(Material.ENDER_PEARL).setDisplayName("§8» §6Forcestart").build());
            inv.setItem(15, new ItemManager(Material.PAPER).setDisplayName("§8» §eMaps").build());
            p.openInventory(inv);
        }
        else if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cVerlassen")) {
            p.kickPlayer("§4Du hast die Runde verlassen");
        }
    }
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getCurrentItem().getItemMeta() == null) {
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        if (e.getInventory().getName().equalsIgnoreCase("§eOptionen")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Forcestart")){
                p.closeInventory();
                if (Data.players.size() >= 2 || Bukkit.getOnlinePlayers().size() >= 2) {
                    if (!SkyWars.forcestarted) {
                        Countdown.forcestart();
                    }else{
                        p.sendMessage(Data.prefix + "Du kannst das Spiel §cnicht §7forcestarten");
                    }
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + "Du kannst jetzt nicht forcestarten");
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §eMaps")){
                Inventory inv = Bukkit.createInventory(null, 45, "§eForcemap");
                for (final String s : SkyWars.cfg.getStringList("Maps")) {
                    inv.addItem(new ItemManager(Material.PAPER).setDisplayName("§c" + s).build());
                }
                inv.setItem(27, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(28, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(29, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(30, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(31, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(32, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(33, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(34, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(35, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());
                inv.setItem(40, new ItemManager(Material.SKULL_ITEM, (short) 3, 1).setSkullOwner("MHF_ArrowLeft").setDisplayName("§4Zurück").build());
                p.openInventory(inv);
            }
        } else if (e.getInventory().getName().equalsIgnoreCase("§eForcemap")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Zurück")){

                Inventory inv = Bukkit.createInventory(null, 9*3, "§eOptionen");

                for(int i = 0; i < inv.getSize(); i++)
                    inv.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE).setDisplayName("§r").build());

                inv.setItem(11, new ItemManager(Material.ENDER_PEARL).setDisplayName("§8» §6Forcestart").build());
                inv.setItem(15, new ItemManager(Material.PAPER).setDisplayName("§8» §eMaps").build());
                p.openInventory(inv);

            } else if (e.getCurrentItem().getType().equals(Material.PAPER)) {
                final String map = SkyWars.currentMap = ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName());
                p.closeInventory();
                p.sendMessage(Data.prefix + "Du hast die Karte auf §6" + map + " §7geändert");
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    ScoreManager.update(all);
                }
            }
        }
    }
    
    @EventHandler
    public void onPickup(final PlayerPickupItemEvent e) {
        if (SkyWars.state == GameState.INGAME) {
            if (Data.players.contains(e.getPlayer())) {
                e.setCancelled(false);
            }
            else {
                e.setCancelled(true);
            }
        }
        else {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onDrop(final PlayerDropItemEvent e) {
        if (SkyWars.state == GameState.INGAME) {
            if (Data.players.contains(e.getPlayer())) {
                e.setCancelled(false);
            }
            else {
                e.setCancelled(true);
            }
        }else {
            e.setCancelled(true);
        }
    }
}
