// 
// Decompiled by Procyon v0.5.36
// 

package de.stuporio.skywars.utils;

import java.util.Random;
import java.util.Iterator;
import org.bukkit.potion.PotionEffect;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class Utils
{
    public static ItemStack create(final Material mat, final int amount) {
        return new ItemStack(mat, amount);
    }
    
    public static ItemStack createItemStack(final ItemStack Itemstack) {
        return Itemstack;
    }
    
    public static int rndInt(final int min, final int max) {
        final Random r = new Random();
        final int i = r.nextInt(max - min + 1) + min;
        return i;
    }
}
