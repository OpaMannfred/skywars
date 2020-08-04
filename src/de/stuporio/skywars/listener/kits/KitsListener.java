// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener.kits;

import de.stuporio.core.utils.coins.*;
import de.stuporio.skywars.utils.SQLKits;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.ItemManager;
import de.stuporio.skywars.utils.ScoreManager;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsListener implements Listener
{
    public static ArrayList<Player> starter;
    public static ArrayList<Player> crafter;
    public static ArrayList<Player> creeper;
    public static ArrayList<Player> poseidon;
    public static ArrayList<Player> enderman;
    public static ArrayList<Player> uhc;
    public static ArrayList<Player> assasine;
    public static ArrayList<Player> tank;
    public static ArrayList<Player> angler;
    public static ArrayList<Player> knocker;

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
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §cKits")) {
            final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9*4, "§cKits");

            for(int i = 0; i < inv.getSize(); i++)
                inv.setItem(i, new ItemManager(Material.STAINED_GLASS_PANE, (short) 15).setDisplayName("§r").build());

            ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("§r");
            itemStack.setItemMeta(itemMeta);

            inv.setItem(0, itemStack);
            inv.setItem(1, itemStack);
            inv.setItem(2, itemStack);
            inv.setItem(3, itemStack);
            inv.setItem(4, itemStack);
            inv.setItem(5, itemStack);
            inv.setItem(6, itemStack);
            inv.setItem(7, itemStack);
            inv.setItem(8, itemStack);
            inv.setItem(9, itemStack);
            inv.setItem(17, itemStack);
            inv.setItem(18, itemStack);
            inv.setItem(26, itemStack);
            inv.setItem(27, itemStack);
            inv.setItem(28, itemStack);
            inv.setItem(29, itemStack);
            inv.setItem(30, itemStack);
            inv.setItem(31, itemStack);
            inv.setItem(32, itemStack);
            inv.setItem(33, itemStack);
            inv.setItem(34, itemStack);
            inv.setItem(35, itemStack);

            if (SQLKits.hasKopf1(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(10, new ItemManager(Material.IRON_AXE).setDisplayName("§bStandart").addLoreLine("§8§m-----------------------").addLoreLine("§eSteinschwert").addLoreLine("§eEisenaxt").addLoreLine("§eEisenspitzhacke").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(10, new ItemManager(Material.IRON_AXE).setDisplayName("§bStandart").addLoreLine("§8§m-----------------------:").addLoreLine("§eSteinschwert").addLoreLine("§eEisenaxt").addLoreLine("§eEisenspitzhacke").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if(SQLKits.hasKopf2(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")){
                inv.setItem(11, new ItemManager(Material.WORKBENCH).setDisplayName("§bCrafter").addLoreLine("§8§m-----------------------").addLoreLine("§e64 Werkbanken").addLoreLine("§e32 Ambossen").addLoreLine("§e32 Sticks").addLoreLine("§e5 Diamanten").addLoreLine("§e5 Eisen").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(11, new ItemManager(Material.WORKBENCH).setDisplayName("§bCrafter").addLoreLine("§8§m-----------------------").addLoreLine("§e64 Werkbanken").addLoreLine("§e32 Ambossen").addLoreLine("§e32 Sticks").addLoreLine("§e5 Diamanten").addLoreLine("§e5 Eisen").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf3(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(12, new ItemManager(Material.TNT).setDisplayName("§bCreeper").addLoreLine("§8§m-----------------------").addLoreLine("§e16 TNT").addLoreLine("§e6 Creeper-Eier").addLoreLine("§e8 Redstone Fackeln").addLoreLine("§e1 Lederhelm mit Explo. Schutz").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(12, new ItemManager(Material.TNT).setDisplayName("§bCreeper").addLoreLine("§8§m-----------------------").addLoreLine("§e16 TNT").addLoreLine("§e6 Creeper-Eier").addLoreLine("§e8 Redstone Fackeln").addLoreLine("§e1 Lederhelm mit Explo. Schutz").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(13, new ItemManager(Material.PRISMARINE_SHARD).setDisplayName("§bPoseidon").addLoreLine("§8§m-----------------------").addLoreLine("§e3 Wassereimer").addLoreLine("§e16 Schneebällen").addLoreLine("§e1 Angel").addLoreLine("§eDiaschwert (Sharp 1)").addLoreLine("§eEisenschuhe (Schutz 2, Wasserläufer 2)").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(13, new ItemManager(Material.PRISMARINE_SHARD).setDisplayName("§bPoseidon").addLoreLine("§8§m-----------------------").addLoreLine("§e3 Wassereimer").addLoreLine("§e16 Schneebällen").addLoreLine("§e1 Angel").addLoreLine("§eDiaschwert (Sharp 1)").addLoreLine("§eEisenschuhe (Schutz 2, Wasserläufer 2)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf5(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(14, new ItemManager(Material.ENDER_PEARL).setDisplayName("§bEnderman").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Enderperle").addLoreLine("§e64 Endstone").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(14, new ItemManager(Material.ENDER_PEARL).setDisplayName("§bEnderman").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Enderperle").addLoreLine("§e64 Endstone").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf6(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(15, new ItemManager(Material.GOLDEN_APPLE).setDisplayName("§bUHC").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Angel").addLoreLine("§e2 Goldäpfel").addLoreLine("§eDiabrustplatte (Schutz 2)").addLoreLine("§eEisenschwert (Schärfe 2)").addLoreLine("§eDiaspitzhacke (Effizienz 2)").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(15, new ItemManager(Material.GOLDEN_APPLE).setDisplayName("§bUHC").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Angel").addLoreLine("§e2 Goldäpfel").addLoreLine("§eDiabrustplatte (Schutz 2)").addLoreLine("§eEisenschwert (Schärfe 2)").addLoreLine("§eDiaspitzhacke (Effizienz 2)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf7(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(16, new ItemManager(Material.DIAMOND_SWORD).setDisplayName("§bAssasine").addLoreLine("§8§m-----------------------").addLoreLine("§eDiaschwert (Schärfe 1)").addLoreLine("§eDiaschuhe (Schutz 2, Federfall 2, Schnelligkeit 1 sobald Schuh an)").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(16, new ItemManager(Material.DIAMOND_SWORD).setDisplayName("§bAssasine").addLoreLine("§8§m-----------------------").addLoreLine("§eDiaschwert (Schärfe 1)").addLoreLine("§eDiaschuhe (Schutz 2, Federfall 2, Schnelligkeit 1 sobald Schuh an)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf8(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(19, new ItemManager(Material.IRON_CHESTPLATE).setDisplayName("§bTank").addLoreLine("§8§m-----------------------").addLoreLine("§eDiahelm (Schutz 1)").addLoreLine("§eEisenbrustplatte (Schutz 2)").addLoreLine("§eEisenhose (Schutz 2)").addLoreLine("§eDiaschuhe (Schutz 1)").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(19, new ItemManager(Material.IRON_CHESTPLATE).setDisplayName("§bTank").addLoreLine("§8§m-----------------------").addLoreLine("§eDiahelm (Schutz 1)").addLoreLine("§eEisenbrustplatte (Schutz 2)").addLoreLine("§eEisenhose (Schutz 2)").addLoreLine("§eDiaschuhe (Schutz 1)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf9(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(20, new ItemManager(Material.FISHING_ROD).setDisplayName("§bAngler").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Angel").addLoreLine("§e3 Wassereimer").addLoreLine("§eDiahelm (Wasseraffenität 2, Schutz 1)").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(20, new ItemManager(Material.FISHING_ROD).setDisplayName("§bAngler").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Angel").addLoreLine("§e3 Wassereimer").addLoreLine("§eDiahelm (Wasseraffenität 2, Schutz 1)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            if (SQLKits.hasKopf10(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                inv.setItem(21, new ItemManager(Material.STICK).setDisplayName("§bKnocker").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Stick (Knockback 1)").addLoreLine("§eEisenschuhe (Schutz 2)").addLoreLine("§e64 Steinblöcke").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
            }else{
                inv.setItem(21, new ItemManager(Material.STICK).setDisplayName("§bKnocker").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Stick (Knockback 1)").addLoreLine("§eEisenschuhe (Schutz 2)").addLoreLine("§e64 Steinblöcke").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
            }
            p.openInventory(inv);
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
        if (e.getInventory() == null) {
            return;
        }
        if (e.getInventory().getName().equalsIgnoreCase("§cKits")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCrafter")) {
                if (SQLKits.hasKopf2(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bCrafter"));
                    this.removeFromArrayList(p);
                    KitsListener.crafter.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§cCrafter Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e6000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.WORKBENCH).setDisplayName("§bCrafter").addLoreLine("§8§m-----------------------").addLoreLine("§e64 Werkbanken").addLoreLine("§e32 Ambossen").addLoreLine("§e32 Sticks").addLoreLine("§e5 Diamanten").addLoreLine("§e5 Eisen").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht Gekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bCreeper")) {
                if (SQLKits.hasKopf3(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bCreeper"));
                    this.removeFromArrayList(p);
                    KitsListener.creeper.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bCreeper Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e12000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.TNT).setDisplayName("§bCreeper").addLoreLine("§8§m-----------------------").addLoreLine("§e16 TNT").addLoreLine("§e6 Creeper-Eier").addLoreLine("§e8 Redstone Fackeln").addLoreLine("§e1 Lederhelm mit Explo. Schutz").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bPoseidon")) {
                if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bPoseidon"));
                    this.removeFromArrayList(p);
                    KitsListener.poseidon.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bPoseidon Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e30000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.BARRIER).setDisplayName("§bPoseidon").addLoreLine("§8§m-----------------------").addLoreLine("§e3 Wassereimer").addLoreLine("§e16 Schneebällen").addLoreLine("§e1 Angel").addLoreLine("§eDiaschwert (Sharp 1)").addLoreLine("§eEisenschuhe (Schutz 2, Wasserläufer 2)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bEnderman")) {
                if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bEnderman"));
                    this.removeFromArrayList(p);
                    KitsListener.enderman.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bPoseidon Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e20000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.BARRIER).setDisplayName("§bEnderman").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Enderperle").addLoreLine("§e64 Endstone").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bUHC")) {
                if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bUHC"));
                    this.removeFromArrayList(p);
                    KitsListener.uhc.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bUHC Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e15000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.BARRIER).setDisplayName("§bUHC").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Angel").addLoreLine("§e2 Goldäpfel").addLoreLine("§eDiabrustplatte (Schutz 2)").addLoreLine("§eEisenschwert (Schärfe 2)").addLoreLine("§eDiaspitzhacke (Effizienz 2)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bAssasine")) {
                if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bAssasine"));
                    this.removeFromArrayList(p);
                    KitsListener.assasine.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bAssasine Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e20000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.BARRIER).setDisplayName("§bAssasine").addLoreLine("§8§m-----------------------").addLoreLine("§eDiaschwert (Schärfe 1)").addLoreLine("§eDiaschuhe (Schutz 2, Federfall 2, Schnelligkeit 1 sobald Schuh an)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bTank")) {
                if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bTank"));
                    this.removeFromArrayList(p);
                    KitsListener.tank.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bTank Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e20000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.BARRIER).setDisplayName("§bTank").addLoreLine("§8§m-----------------------").addLoreLine("§eDiahelm (Schutz 1)").addLoreLine("§eEisenbrustplatte (Schutz 2)").addLoreLine("§eEisenhose (Schutz 2)").addLoreLine("§eDiaschuhe (Schutz 1)").addLoreLine("§8§m-----------------------§0").addLoreLine("§cNicht gekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bAngler")) {
                if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bAngler"));
                    this.removeFromArrayList(p);
                    KitsListener.angler.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bAngler Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e5000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.FISHING_ROD).setDisplayName("§bAngler").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Angel").addLoreLine("§e3 Wassereimer").addLoreLine("§eDiahelm (Wasseraffenität 2, Schutz 1)").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bKnocker")) {
                if (SQLKits.hasKopf4(p.getUniqueId().toString()) || p.hasPermission("sw.kits.all")) {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.setCurrentKit.replace("%kit%", "§bKnocker"));
                    this.removeFromArrayList(p);
                    KitsListener.knocker.add(p);
                    ScoreManager.update(p);
                }
                else {
                    final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§bKnocker Kaufen");
                    inv.setItem(2, new ItemManager(Material.STAINED_CLAY, (short)5, 1).setDisplayName("§aKaufen").addLoreLine("").addLoreLine("§7Kosten:").addLoreLine("§e15000 Coins").build());
                    inv.setItem(4, new ItemManager(Material.STICK).setDisplayName("§bKnocker").addLoreLine("§8§m-----------------------").addLoreLine("§e1 Stick (Knockback 1)").addLoreLine("§eEisenschuhe (Schutz 2)").addLoreLine("§e64 Steinblöcke").addLoreLine("§8§m-----------------------§0").addLoreLine("§aGekauft").build());
                    inv.setItem(6, new ItemManager(Material.STAINED_CLAY, (short)14, 1).setDisplayName("§4Abbrechen").build());
                    p.openInventory(inv);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bStandart")) {
                p.closeInventory();
                this.removeFromArrayList(p);
                KitsListener.starter.add(p);
                p.sendMessage(Data.prefix + "Du hast das Kit §eStandart §7ausgew\u00e4hlt");
                ScoreManager.update(p);
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§cCrafter Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 4000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 4000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§6Crafter"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, true, KitAPI.getCreeper());*/
                    SQLKits.setKopf2(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bCreeper Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 12000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 12000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§6Creeper"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, KitAPI.getCrafter(), true);*/
                    SQLKits.setKopf3(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bPoseidon Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 30000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 30000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§bPoseidon"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, KitAPI.getCrafter(), true);*/
                    SQLKits.setKopf4(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bEnderman Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 20000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 20000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§bEnderman"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, KitAPI.getCrafter(), true);*/
                    SQLKits.setKopf5(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bUHC Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 15000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 15000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§bUHC"));
                    SQLKits.setKopf6(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bAssasine Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 20000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 20000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§bAssasine"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, KitAPI.getCrafter(), true);*/
                    SQLKits.setKopf7(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bTank Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 20000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 20000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§bTank"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, KitAPI.getCrafter(), true);*/
                    SQLKits.setKopf8(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bAngler Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 5000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 5000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§bAngler"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, KitAPI.getCrafter(), true);*/
                    SQLKits.setKopf9(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equalsIgnoreCase("§bKnocker Kaufen")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aKaufen")) {
                if (CoinsAPI.hasEnoughCoins(p.getUniqueId().toString(), 15000)) {
                    CoinsAPI.removeCoins(p.getUniqueId().toString(), 15000);
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.kitBuyed.replace("%kit%", "§bKnocker"));
                    /*KitAPI.kits(KitAPI.getJoin(), true, KitAPI.getCrafter(), true);*/
                    SQLKits.setKopf10(p.getUniqueId().toString(), 10);
                }
                else {
                    p.closeInventory();
                    p.sendMessage(Data.prefix + Data.noCoins);
                }
            }
            else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Abbrechen")) {
                p.closeInventory();
            }
        }
    }
    
    public void removeFromArrayList(final Player p) {
        KitsListener.starter.remove(p);
        KitsListener.crafter.remove(p);
        KitsListener.creeper.remove(p);
        KitsListener.tank.remove(p);
        KitsListener.uhc.remove(p);
        KitsListener.assasine.remove(p);
        KitsListener.enderman.remove(p);
        KitsListener.poseidon.remove(p);
        KitsListener.angler.remove(p);
        KitsListener.knocker.remove(p);
    }
    
    public static void setKits(final Player p) {
        if (KitsListener.starter.contains(p)) {
            p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
            p.getInventory().addItem(new ItemStack(Material.IRON_AXE));
            p.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
            p.updateInventory();
            return;
        }
        if (KitsListener.crafter.contains(p)) {
            p.getInventory().addItem(new ItemStack(Material.WORKBENCH, 64));
            p.getInventory().addItem(new ItemStack(Material.ANVIL, 32));
            p.getInventory().addItem(new ItemStack(Material.STICK, 32));
            p.getInventory().addItem(new ItemStack(Material.DIAMOND, 5));
            p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 5));
            return;
        }
        if (KitsListener.creeper.contains(p)) {
            p.getInventory().addItem(new ItemStack(Material.TNT, 16));
            p.getInventory().addItem(new ItemManager(Material.MONSTER_EGG, (short)50, 1).build());
            p.getInventory().addItem(new ItemManager(Material.REDSTONE_TORCH_ON, 8).build());
            p.getInventory().setHelmet(new ItemManager(Material.LEATHER_HELMET, 1).addEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1).build());
            return;
        }
        if (KitsListener.poseidon.contains(p)) {
            p.getInventory().addItem(new ItemManager(Material.WATER_BUCKET, 3).build());
            p.getInventory().addItem(new ItemManager(Material.SNOW_BALL, 16).build());
            p.getInventory().addItem(new ItemManager(Material.FISHING_ROD).build());
            p.getInventory().addItem(new ItemManager(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
            p.getInventory().setBoots(new ItemManager(Material.IRON_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.DEPTH_STRIDER, 2).build());
            return;
        }
        if (KitsListener.enderman.contains(p)) {
            p.getInventory().addItem(new ItemManager(Material.ENDER_PEARL).build());
            p.getInventory().addItem(new ItemManager(Material.ENDER_STONE, 64).build());
            return;
        }
        if (KitsListener.uhc.contains(p)) {
            p.getInventory().addItem(new ItemManager(Material.COBBLESTONE, 64).build());
            p.getInventory().addItem(new ItemManager(Material.FISHING_ROD).build());
            p.getInventory().addItem(new ItemManager(Material.GOLDEN_APPLE, 2).build());
            p.getInventory().setChestplate(new ItemManager(Material.DIAMOND_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
            p.getInventory().addItem(new ItemManager(Material.IRON_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 2).build());
            p.getInventory().addItem(new ItemManager(Material.DIAMOND_PICKAXE).addEnchantment(Enchantment.DIG_SPEED, 2).build());
            return;
        }
        if (KitsListener.assasine.contains(p)) {
            p.getInventory().addItem(new ItemManager(Material.DIAMOND_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 1).build());
            p.getInventory().setBoots(new ItemManager(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).addEnchantment(Enchantment.PROTECTION_FALL, 2).build());
            return;
        }
        if (KitsListener.tank.contains(p)) {
            p.getInventory().setHelmet(new ItemManager(Material.DIAMOND_HELMET).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
            p.getInventory().setChestplate(new ItemManager(Material.IRON_CHESTPLATE).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
            p.getInventory().setLeggings(new ItemManager(Material.IRON_LEGGINGS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
            p.getInventory().setBoots(new ItemManager(Material.DIAMOND_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
            return;
        }
        if (KitsListener.angler.contains(p)) {
            p.getInventory().addItem(new ItemManager(Material.WATER_BUCKET, 3).build());
            p.getInventory().addItem(new ItemManager(Material.FISHING_ROD).build());
            p.getInventory().setHelmet(new ItemManager(Material.DIAMOND_HELMET).addEnchantment(Enchantment.WATER_WORKER, 2).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1).build());
            return;
        }
        if (KitsListener.knocker.contains(p)) {
            p.getInventory().addItem(new ItemManager(Material.STICK).addEnchantment(Enchantment.KNOCKBACK, 1).build());
            p.getInventory().setBoots(new ItemManager(Material.IRON_BOOTS).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).build());
            p.getInventory().addItem(new ItemManager(Material.STONE).build());
            return;
        }
    }
    
    static {
        KitsListener.starter = new ArrayList<>();
        KitsListener.crafter = new ArrayList<>();
        KitsListener.creeper = new ArrayList<>();
        KitsListener.assasine = new ArrayList<>();
        KitsListener.tank = new ArrayList<>();
        KitsListener.uhc = new ArrayList<>();
        KitsListener.enderman = new ArrayList<>();
        KitsListener.poseidon = new ArrayList<>();
        KitsListener.angler = new ArrayList<>();
        KitsListener.knocker = new ArrayList<>();
    }
}
