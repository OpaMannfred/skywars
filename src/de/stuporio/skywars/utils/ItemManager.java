// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils;

import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.DyeColor;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.Color;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.enchantments.Enchantment;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import org.bukkit.inventory.ItemStack;

public class ItemManager
{
    private ItemStack item;
    private List<String> lore;
    private ItemMeta meta;
    
    public ItemManager(final Material mat, final short subid, final int amount) {
        this.lore = new ArrayList<String>();
        this.item = new ItemStack(mat, amount, subid);
        this.meta = this.item.getItemMeta();
    }
    
    public ItemManager(final ItemStack item) {
        this.lore = new ArrayList<String>();
        this.item = item;
        this.meta = item.getItemMeta();
    }
    
    public ItemManager(final Material mat, final short subid) {
        this.lore = new ArrayList<String>();
        this.item = new ItemStack(mat, 1, subid);
        this.meta = this.item.getItemMeta();
    }
    
    public ItemManager(final Material mat, final int amount) {
        this.lore = new ArrayList<String>();
        this.item = new ItemStack(mat, amount, (short)0);
        this.meta = this.item.getItemMeta();
    }
    
    public ItemManager(final Material mat) {
        this.lore = new ArrayList<String>();
        this.item = new ItemStack(mat, 1, (short)0);
        this.meta = this.item.getItemMeta();
    }
    
    public ItemManager setAmount(final int value) {
        this.item.setAmount(value);
        return this;
    }
    
    public ItemManager setNoName() {
        this.meta.setDisplayName(" ");
        return this;
    }
    
    public ItemManager setGlow() {
        this.meta.addEnchant(Enchantment.DURABILITY, 1, true);
        this.meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
        return this;
    }
    
    public ItemManager setData(final short data) {
        this.item.setDurability(data);
        return this;
    }
    
    public ItemManager addLoreLine(final String line) {
        this.lore.add(line);
        return this;
    }
    
    public ItemManager addLoreArray(final String[] lines) {
        for (int x = 0; x < lines.length; ++x) {
            this.lore.add(lines[x]);
        }
        return this;
    }
    
    public ItemManager addLoreAll(final List<String> lines) {
        this.lore.addAll(lines);
        return this;
    }
    
    public ItemManager setDisplayName(final String name) {
        this.meta.setDisplayName(name);
        return this;
    }
    
    public ItemManager setSkullOwner(final String owner) {
        ((SkullMeta)this.meta).setOwner(owner);
        return this;
    }
    
    public ItemManager setColor(final Color c) {
        ((LeatherArmorMeta)this.meta).setColor(c);
        return this;
    }
    
    public ItemManager getBannerColor(final DyeColor c) {
        ((BannerMeta)this.meta).setBaseColor(c);
        return this;
    }
    
    public ItemManager setUnnbreakable(final boolean value) {
        this.meta.spigot().setUnbreakable(value);
        return this;
    }
    
    public ItemManager addEnchantment(final Enchantment ench, final int lvl) {
        this.meta.addEnchant(ench, lvl, true);
        return this;
    }
    
    public ItemManager addItemFlag(final ItemFlag flag) {
        this.meta.addItemFlags(new ItemFlag[] { flag });
        return this;
    }
    
    public ItemManager addLeatherColor(final Color c) {
        ((LeatherArmorMeta)this.meta).setColor(c);
        return this;
    }
    
    public ItemStack build() {
        if (!this.lore.isEmpty()) {
            this.meta.setLore((List)this.lore);
        }
        this.item.setItemMeta(this.meta);
        return this.item;
    }
}
