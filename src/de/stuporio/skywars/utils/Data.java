package de.stuporio.skywars.utils;

import org.bukkit.ChatColor;
import de.stuporio.skywars.SkyWars;
import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Data
{
    public static ArrayList<Player> builder;
    public static ArrayList<Player> gg;
    public static String prefix;
    public static ArrayList<Player> freeze;
    public static ArrayList<Player> players;
    public static String kitBuyed;
    public static String noCoins;
    public static String setCurrentKit;

    public static ArrayList<Player> spectator = new ArrayList<>();

    public static ArrayList<Location> selfPlacedChest = new ArrayList<>();

    static {
        Data.builder = new ArrayList<>();
        Data.gg = new ArrayList<>();
        Data.prefix = "§9•§3● SkyWars §8§l▏ §7";
        Data.freeze = new ArrayList<>();
        Data.players = new ArrayList<>();
        Data.kitBuyed = ChatColor.translateAlternateColorCodes('&', String.valueOf(SkyWars.getInstance().getConfig().get("Message.Kit.Buyed")));
        Data.noCoins = ChatColor.translateAlternateColorCodes('&', String.valueOf(SkyWars.getInstance().getConfig().get("Message.Kit.NoCoins")));
        Data.setCurrentKit = ChatColor.translateAlternateColorCodes('&', String.valueOf(SkyWars.getInstance().getConfig().get("Message.Kit.Current")));
    }
}
