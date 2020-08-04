// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.listener;

import de.stuporio.skywars.SkyWars;
import de.stuporio.skywars.state.GameState;
import de.stuporio.skywars.utils.Data;
import de.stuporio.skywars.utils.Utils;
import org.bukkit.block.Chest;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.Sound;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;

import org.bukkit.Location;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class ChestListener implements Listener
{

    private ArrayList<ItemStack> loot;
    public static HashMap<Inventory, Location> saved = new HashMap<Inventory, Location>();
    public static HashMap<Location, Inventory> chests = new HashMap<>();
    
    public ChestListener() {
        this.loot = new ArrayList<ItemStack>();
    }
    
    @EventHandler
    public void onChestOpen(final PlayerInteractEvent e) {
        try {
            final Player player = e.getPlayer();
            if ((e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.CHEST && SkyWars.state == GameState.INGAME) || e.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
                /*if (!ChestListener.chests.containsKey(e.getClickedBlock().getLocation())) {*/
                if (!Data.selfPlacedChest.contains(e.getClickedBlock().getLocation())) {
                    if (!ChestListener.chests.containsKey(e.getClickedBlock().getLocation())) {
                        this.registerLoot();
                        Chest chest = (Chest) e.getClickedBlock().getState();
                        chest.getInventory().clear();
                        for (int i = 0; i < Utils.rndInt(15, 22); ++i) {
                            chest.getInventory().setItem(Utils.rndInt(0, chest.getInventory().getSize() - 1), (ItemStack) this.loot.get(Utils.rndInt(0, this.loot.size() - 1)));
                        }
                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
                        ChestListener.chests.put(e.getClickedBlock().getLocation(), chest.getBlockInventory());
                    }
                }else{
                    Chest chest = (Chest) e.getClickedBlock().getState();
                    chest.getInventory().clear();
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(SkyWars.state == GameState.INGAME){
            if(e.getBlockPlaced().getType() == Material.CHEST){
                Data.selfPlacedChest.add(e.getBlockPlaced().getLocation());
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        if (!Data.selfPlacedChest.contains(e.getBlock().getLocation())) {
            this.registerLoot();
            Chest chest = (Chest) e.getBlock().getState();
            chest.getInventory().clear();
            for (int i = 0; i < Utils.rndInt(15, 22); ++i) {
                chest.getInventory().setItem(Utils.rndInt(0, chest.getInventory().getSize() - 1), (ItemStack) this.loot.get(Utils.rndInt(0, this.loot.size() - 1)));
            }
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }else{
            Chest chest = (Chest) e.getBlock().getState();
            chest.getInventory().clear();
        }
    }
    
    public void registerLoot() {
        final ItemStack regeneration = new ItemStack(Material.POTION, 1, (short)8225);
        final ItemStack speed = new ItemStack(Material.POTION, 1, (short)8194);
        final ItemStack direktheilung = new ItemStack(Material.POTION, 1, (short)16421);
        final ItemStack langsamkeit = new ItemStack(Material.POTION, 1, (short)16426);
        final ItemStack schwache = new ItemStack(Material.POTION, 1, (short)16424);
        final ItemStack direktschaden = new ItemStack(Material.POTION, 1, (short)16460);
        final ItemStack vergif = new ItemStack(Material.POTION, 1, (short)16388);
        final ItemStack eh = new ItemStack(Material.IRON_HELMET);
        final ItemMeta e = eh.getItemMeta();
        e.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        eh.setItemMeta(e);
        final ItemStack eh2 = new ItemStack(Material.IRON_CHESTPLATE);
        final ItemMeta e2 = eh2.getItemMeta();
        e2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        eh2.setItemMeta(e2);
        final ItemStack eh3 = new ItemStack(Material.IRON_LEGGINGS);
        final ItemMeta e3 = eh3.getItemMeta();
        e3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        eh3.setItemMeta(e3);
        final ItemStack eh4 = new ItemStack(Material.IRON_BOOTS);
        final ItemMeta e4 = eh4.getItemMeta();
        e4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        eh4.setItemMeta(e4);
        final ItemStack dh = new ItemStack(Material.CHAINMAIL_BOOTS);
        final ItemMeta dm = dh.getItemMeta();
        dm.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        dh.setItemMeta(dm);
        final ItemStack dh2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
        final ItemMeta dm2 = dh2.getItemMeta();
        dm2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        dh2.setItemMeta(dm2);
        final ItemStack dh3 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        final ItemMeta dm3 = dh3.getItemMeta();
        dm3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        dh3.setItemMeta(dm3);
        final ItemStack dh4 = new ItemStack(Material.CHAINMAIL_HELMET);
        final ItemMeta dm4 = dh4.getItemMeta();
        dm4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        dh4.setItemMeta(dm4);
        final ItemStack ws = new ItemStack(Material.WOOD_SWORD);
        final ItemMeta w = ws.getItemMeta();
        w.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        ws.setItemMeta(w);
        final ItemStack ws2 = new ItemStack(Material.STONE_SWORD);
        final ItemMeta w2 = ws2.getItemMeta();
        w2.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        ws2.setItemMeta(w2);
        final ItemStack ws3 = new ItemStack(Material.IRON_SWORD);
        final ItemMeta w3 = ws2.getItemMeta();
        w3.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        ws3.setItemMeta(w3);
        this.loot.add(ws3);
        this.loot.add(ws);
        this.loot.add(dh);
        this.loot.add(dh2);
        this.loot.add(dh3);
        this.loot.add(dh4);
        this.loot.add(eh);
        this.loot.add(eh2);
        this.loot.add(eh3);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(direktschaden);
        this.loot.add(speed);
        this.loot.add(speed);
        this.loot.add(speed);
        this.loot.add(speed);
        this.loot.add(speed);
        this.loot.add(speed);
        this.loot.add(speed);
        this.loot.add(eh4);
        this.loot.add(dh);
        this.loot.add(dh2);
        this.loot.add(dh3);
        this.loot.add(dh4);
        this.loot.add(eh);
        this.loot.add(eh2);
        this.loot.add(eh3);
        this.loot.add(eh4);
        this.loot.clear();
        this.loot.add(Utils.createItemStack(regeneration));
        this.loot.add(Utils.createItemStack(direktheilung));
        this.loot.add(Utils.createItemStack(langsamkeit));
        this.loot.add(Utils.createItemStack(schwache));
        this.loot.add(Utils.createItemStack(vergif));
        this.loot.add(Utils.createItemStack(regeneration));
        this.loot.add(Utils.create(Material.WOOD_SWORD, 1));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(ws);
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.DIAMOND, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.DIAMOND, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.IRON_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.IRON_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.IRON_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.GOLD_INGOT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(ws);
        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.TNT, Utils.rndInt(1, 8)));
        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.FLINT_AND_STEEL, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(ws);
        this.loot.add(ws2);
        this.loot.add(ws3);
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.STONE_AXE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(ws);
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.WEB, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(dh);
        this.loot.add(dh2);
        this.loot.add(dh3);
        this.loot.add(dh4);
        this.loot.add(eh);
        this.loot.add(eh2);
        this.loot.add(eh3);
        this.loot.add(eh4);
        this.loot.add(dh);
        this.loot.add(dh2);
        this.loot.add(dh3);
        this.loot.add(dh4);
        this.loot.add(ws);
        this.loot.add(eh);
        this.loot.add(eh2);
        this.loot.add(eh3);
        this.loot.add(eh4);

        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.STONE_AXE, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(ws);
        this.loot.add(ws2);
        this.loot.add(ws3);
        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.STICK, Utils.rndInt(1, 3)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));

        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.GOLD_PICKAXE, 1));
        this.loot.add(Utils.create(Material.GOLD_PICKAXE, 1));
        this.loot.add(Utils.create(Material.GOLD_PICKAXE, 1));
        this.loot.add(Utils.create(Material.IRON_PICKAXE, 1));
        this.loot.add(Utils.create(Material.IRON_PICKAXE, 1));
        this.loot.add(Utils.create(Material.IRON_PICKAXE, 1));
        this.loot.add(Utils.create(Material.DIAMOND_PICKAXE, 1));
        this.loot.add(Utils.create(Material.DIAMOND_PICKAXE, 1));
        this.loot.add(Utils.create(Material.DIAMOND_PICKAXE, 1));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(ws);
        this.loot.add(ws3);
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_HELMET, 1));
        this.loot.add(Utils.create(Material.IRON_HELMET, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(ws);
        this.loot.add(ws2);
        this.loot.add(Utils.create(Material.STONE_SWORD, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.IRON_SWORD, 1));
        this.loot.add(Utils.create(Material.DIAMOND_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.ARROW, Utils.rndInt(1, 4)));
        this.loot.add(Utils.create(Material.FISHING_ROD, 1));
        this.loot.add(Utils.create(Material.GOLD_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.IRON_CHESTPLATE, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.GOLDEN_APPLE, 1));
        this.loot.add(Utils.create(Material.CHAINMAIL_BOOTS, 1));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BOW, 1));
        this.loot.add(Utils.create(Material.BAKED_POTATO, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.IRON_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.IRON_BOOTS, 1));
        this.loot.add(Utils.create(Material.COOKED_CHICKEN, Utils.rndInt(1, 5)));
        this.loot.add(Utils.create(Material.CHAINMAIL_LEGGINGS, 1));
        this.loot.add(Utils.create(Material.COOKED_BEEF, Utils.rndInt(1, 5)));
        this.loot.add(ws);
        this.loot.add(Utils.create(Material.GOLD_BOOTS, 1));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.STONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.COBBLESTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.SANDSTONE, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WOOD, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.BRICK, Utils.rndInt(1, 64)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.ENDER_PEARL, Utils.rndInt(1, 2)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.WATER_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.LAVA_BUCKET, Utils.rndInt(1, 1)));
        this.loot.add(Utils.create(Material.ENDER_PEARL, Utils.rndInt(1, 2)));
        this.loot.add(ws2);
        this.loot.add(ws3);
    }
}
